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
    HashMap<String, QuestionSet> questionData;

//    RadioGroup radioGroup;
    RadioButton radioButtonA;
    RadioButton radioButtonB;
    RadioButton radioButtonC;
    RadioButton radioButtonD;
    TextView questionText;
    TextView questionNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        QuestionSetCaller dbHelper = new QuestionSetCaller(this);
//        savedInstanceState.get
        Bundle savedData = getIntent().getExtras();
        String subjectTableName = savedData.getString("subject");

        questionData = dbHelper.getQuestionSet(subjectTableName);

        TextView questionNum = (TextView) findViewById(R.id.question_number);   //Grabs the link to the question number
        TextView questionText = findViewById(R.id.question_text);  //Grabs the link to the question text
        RadioGroup radioGroup = findViewById(R.id.answer_group); //Grabs the link to the radio group of answers
        radioButtonA = findViewById(R.id.answerA);
        radioButtonB = findViewById(R.id.answerB);
        radioButtonC = findViewById(R.id.answerC);
        radioButtonD = findViewById(R.id.answerD);
        String[] answerSetData = new String[5];
        String correctAnswer = null;


//        answerSetData = questionData.get("Question 1").getAnswerSet();
        questionNum.setText("Question 1");
        questionText.setText(Objects.requireNonNull(questionData.get("Question 1")).getQuestion());
        radioButtonA.setText(answerSetData[0]);
        radioButtonB.setText(answerSetData[1]);
        radioButtonC.setText(answerSetData[2]);
        radioButtonD.setText(answerSetData[3]);
        correctAnswer = answerSetData[4];


//        for(String question : questionData.keySet())
//        {
//            answerSetData = questionData.get(question).getAnswerSet();
//            questionNum.setText(question);
//            questionText.setText(Objects.requireNonNull(questionData.get(question)).getQuestion());
//            radioButtonA.setText(answerSetData[0]);
//            radioButtonB.setText(answerSetData[1]);
//            radioButtonC.setText(answerSetData[2]);
//            radioButtonD.setText(answerSetData[3]);
//            correctAnswer = answerSetData[4];
//            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
//            {
//                @Override
//                public void onCheckedChanged(RadioGroup radioGroup, int id)
//                {
//                    String questionResult = "CORRECT";
//                    switch (id)
//                    {
//                        case R.id.answerA:
//                            openQuestion_Result_Activity(questionResult);
//                            break;
//                        case R.id.answerB:
//                            openQuestion_Result_Activity(questionResult);
//                            break;
//                        case R.id.answerC:
//                            openQuestion_Result_Activity(questionResult);
//                            break;
//                        case R.id.answerD:
//                            openQuestion_Result_Activity(questionResult);
//                            break;
//                    }
//
//                }

//            });
//        }
        setContentView(R.layout.quiz_activity);
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
