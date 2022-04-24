package com.triviapop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

<<<<<<< Updated upstream
=======
import android.annotation.SuppressLint;
>>>>>>> Stashed changes
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

<<<<<<< Updated upstream
public class Quiz_Activity extends AppCompatActivity {
=======
import com.triviapop.questionset.QuestionSet;

import java.util.LinkedList;
>>>>>>> Stashed changes

    private Button button_result;

    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView questionText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Quiz_Activity", "Entered new activity.");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_activity);
<<<<<<< Updated upstream
        radioGroup = findViewById(R.id.answer_group); //Grabs the radio group
        questionText = findViewById(R.id.question_text);  //Grabs the question
=======
        Bundle savedData = getIntent().getExtras();
        subject = savedData.getString("subject");

        //resets the class variables.
        count = 0;
        numCorrect = 0;
        questionData = new LinkedList<>();

        QuestionSetCaller dbHelper = new QuestionSetCaller(this);
        questionData = dbHelper.getQuestionSet(subject);
        Log.i("INFO", "SIZE OF HASHMAP IS " + questionData.size());
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        setContentView(R.layout.quiz_activity);
        Log.i("INFO", "Quiz was resumed");

        //finds ID's of radio buttons and text views
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.answer_group); //Grabs the link to the radio group of answers
        //Sets background image
        switch (subject)
        {
            case "History":
                radioGroup.setBackgroundResource(R.drawable.history_bg);
                break;
            case "Entertainment":
                radioGroup.setBackgroundResource(R.drawable.entertainment_bg);
                break;
            case "Science":
                radioGroup.setBackgroundResource(R.drawable.science_bg);
                break;
            default:
                radioGroup.setBackgroundResource(R.color.white);
        }
        RadioButton radioButtonA = (RadioButton) findViewById(R.id.answerA);
        RadioButton radioButtonB = (RadioButton) findViewById(R.id.answerB);
        RadioButton radioButtonC = (RadioButton) findViewById(R.id.answerC);
        RadioButton radioButtonD = (RadioButton) findViewById(R.id.answerD);

        TextView questionNumView = (TextView) findViewById(R.id.question_number);   //Grabs the link to the question number
        TextView questionTextView = (TextView)findViewById(R.id.question_text);  //Grabs the link to the question text
        AppCompatButton toMenuButton = (AppCompatButton) findViewById(R.id.return_to_menu);

        //Gets the questionSet object at the index specified by count
        QuestionSet questionSet = questionData.get(count);
        String questionNum = "Question " + (count + 1);
        String factText = questionSet.getFact();

        Log.d("DEBUG", "Count: " + count);
        Log.d("DEBUG", "Question number:" + questionNum);
        Log.d("DEBUG", "Fact:" + factText);

        //Sets the values for the views and radio buttons
        questionNumView.setText(questionNum);
        questionTextView.setText(questionSet.getQuestion());
        radioButtonA.setText(questionSet.getAnswerSet().getA());
        radioButtonB.setText(questionSet.getAnswerSet().getB());
        radioButtonC.setText(questionSet.getAnswerSet().getC());
        radioButtonD.setText(questionSet.getAnswerSet().getD());

        //Functions that setup the event handlers for the buttons
        scanForReturn(toMenuButton);
        scanForClick(radioGroup, questionSet);
    }
>>>>>>> Stashed changes

//        Button buttonsubmit = findViewById(R.id.button_submit);
//        buttonsubmit.setOnClickListener(new View.OnClickListener())

        AppCompatButton returnToMenuButton = findViewById(R.id.return_to_menu);
        returnToMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returntomenu(view);
            }
        });


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id)
            {
                switch (id)
                {
                    case R.id.answerA:
                        openQuestion_Result_Activity();
                        break;
                    case R.id.answerB:
                        openQuestion_Result_Activity();
                        break;
                    case R.id.answerC:
                        openQuestion_Result_Activity();
                        break;
                    case R.id.answerD:
                        openQuestion_Result_Activity();
                        break;
                }

            }
        });
//        {
//            @Override
//            public void onClick(View view) {
//                int radioID = radioGroup.getCheckedRadioButtonId();
//
//                radioButton = findViewById(radioID);
//
//                questionText.setText("Result: " + radioButton.getText());
//            }
//        });
    }

    public void checkButton(View v) {
        int radioID = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioID);

        Toast.makeText(this, "Selected Radio Button: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
    }

    public void returntomenu(View view) {
        startActivity(new Intent(Quiz_Activity.this,MainActivity.class));
    }
    public void openQuestion_Result_Activity() {
        Intent intent = new Intent(this, Question_Result_Activity.class);
        startActivity(intent);
    }
}
