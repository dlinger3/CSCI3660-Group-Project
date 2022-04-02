package com.triviapop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.triviapop.questProcessing.QuestionSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

public class Quiz_Activity extends AppCompatActivity {

    private Button button_result;
    LinkedList<QuestionSet> questionData = new LinkedList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_activity);
        TextView questionNumView = (TextView) findViewById(R.id.question_number);   //Grabs the link to the question number
        TextView questionTextView = (TextView)findViewById(R.id.question_text);  //Grabs the link to the question text
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.answer_group); //Grabs the link to the radio group of answers
        RadioButton radioButtonA = (RadioButton) findViewById(R.id.answerA);
        RadioButton radioButtonB = (RadioButton) findViewById(R.id.answerB);
        RadioButton radioButtonC = (RadioButton) findViewById(R.id.answerC);
        RadioButton radioButtonD = (RadioButton) findViewById(R.id.answerD);

        QuestionSetCaller dbHelper = new QuestionSetCaller(this);
//        savedInstanceState.get
        Bundle savedData = getIntent().getExtras();
        String subjectTableName = savedData.getString("subject");

        questionData = dbHelper.getQuestionSet(subjectTableName);
        String[] answerSetData = new String[5];
        boolean buttonClicked = false;

        Log.i("INFO", "SIZE OF HASHMAP IS " + questionData.size());
        int count = 1;
        for(QuestionSet question : questionData)
        {
            Log.d("DEBUG", "LOOP COUNT:" + count);
            String questionNum = "Question " + count;
            String questionText = question.getQuestion();
            answerSetData = question.getAnswerSet();
            String answerA = answerSetData[0];
            String answerB = answerSetData[1];
            String answerC = answerSetData[2];
            String answerD = answerSetData[3];
            String correctAnswer = answerSetData[4];
            questionNumView.setText(questionNum);
            questionTextView.setText(questionText);
            radioButtonA.setText(answerA);
            radioButtonB.setText(answerB);
            radioButtonC.setText(answerC);
            radioButtonD.setText(answerD);
            while(!buttonClicked)
            {

            }
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
            {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int id)
                {
                    String questionResult = "CORRECT";
                    switch (id)
                    {
                        case R.id.answerA:
                            openQuestion_Result_Activity(questionResult);
                            break;
                        case R.id.answerB:
                            openQuestion_Result_Activity(questionResult);
                            break;
                        case R.id.answerC:
                            openQuestion_Result_Activity(questionResult);
                            break;
                        case R.id.answerD:
                            openQuestion_Result_Activity(questionResult);
                            break;
                    }
                }
            });
            count++;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    //    public void checkButton(View v) {
//        int radioID = radioGroup.getCheckedRadioButtonId();
//
//        radioButton = findViewById(radioID);
//
//        Toast.makeText(this, "Selected Radio Button: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
//    }

    public void returntomenu(View view) {
        startActivity(new Intent(Quiz_Activity.this,MainActivity.class));
    }
    public void openQuestion_Result_Activity(String questionResult) {
        Intent intent = new Intent(this, Question_Result_Activity.class);
        intent.putExtra("result", questionResult);
        startActivity(intent);
    }
}
