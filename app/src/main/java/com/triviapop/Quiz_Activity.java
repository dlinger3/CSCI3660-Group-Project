package com.triviapop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
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

import com.triviapop.questProcessing.Question;
import com.triviapop.questProcessing.QuestionSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

//TODO Pressing the app list icon on phone emulator is likely calling onPause(), pausing the app and then calling onResume() upon entering the app again,
// at which point skips to the next question. This needs to be fixed so that the activity loads the correct question again upon resuming. Bundling the count variable, and
// decrementing within the onPause(), and then sending the decremented count back to onResume() could be a solution.

public class Quiz_Activity extends AppCompatActivity {

    private static final int NUMBER_QUESTIONS_IN_QUIZ = 10;
    private static int count;
    private static int numCorrect;
    private static LinkedList<QuestionSet> questionData;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_activity);
        Log.i("INFO", "Quiz was created");
        Bundle savedData = getIntent().getExtras();
        String subjectTableName = savedData.getString("subject");

        //resets the class variables.
        count = 0;
        numCorrect = 0;
        questionData = new LinkedList<>();

        QuestionSetCaller dbHelper = new QuestionSetCaller(this);
        questionData = dbHelper.getQuestionSet(subjectTableName);
        Log.i("INFO", "SIZE OF HASHMAP IS " + questionData.size());
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        setContentView(R.layout.quiz_activity);
        Log.i("INFO", "Quiz was resumed");

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.answer_group); //Grabs the link to the radio group of answers
        RadioButton radioButtonA = (RadioButton) findViewById(R.id.answerA);
        RadioButton radioButtonB = (RadioButton) findViewById(R.id.answerB);
        RadioButton radioButtonC = (RadioButton) findViewById(R.id.answerC);
        RadioButton radioButtonD = (RadioButton) findViewById(R.id.answerD);

        TextView questionNumView = (TextView) findViewById(R.id.question_number);   //Grabs the link to the question number
        TextView questionTextView = (TextView)findViewById(R.id.question_text);  //Grabs the link to the question text
        AppCompatButton toMenuButton = (AppCompatButton) findViewById(R.id.return_to_menu);

        QuestionSet questionSet = questionData.get(count);
        String questionNum = "Question " + (count + 1);
        String factText = questionSet.getFact();

        Log.d("DEBUG", "Count: " + count);
        Log.d("DEBUG", "Question number:" + questionNum);
        Log.d("DEBUG", "Fact:" + factText);


        questionNumView.setText(questionNum);
        questionTextView.setText(questionSet.getQuestion());
        radioButtonA.setText(questionSet.getAnswerSet().getA());
        radioButtonB.setText(questionSet.getAnswerSet().getB());
        radioButtonC.setText(questionSet.getAnswerSet().getC());
        radioButtonD.setText(questionSet.getAnswerSet().getD());

        scanForReturn(toMenuButton);
        scanForClick(radioGroup, questionSet);
        count++;
    }

    private void scanForReturn(AppCompatButton toMenuButton) {

        toMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Quiz_Activity.this,MainActivity.class));
                finish();
            }
        });
    }

    private void openQuestion_Result_Activity(boolean wasCorrect, String factText) {
        Intent intent = new Intent(this, Question_Result_Activity.class);
        intent.putExtra("result", wasCorrect);
        intent.putExtra("count", count);
        intent.putExtra("fact", factText);
        intent.putExtra("correct", numCorrect);
        startActivity(intent);
    }

    @SuppressLint("NonConstantResourceId")
    public void scanForClick(View view, QuestionSet questionSet)
    {
        String correctAnswer = questionSet.getAnswerSet().getCorrectAnswer();
        String factText = questionSet.getFact();

        RadioButton radioButtonA = (RadioButton) findViewById(R.id.answerA);
        RadioButton radioButtonB = (RadioButton) findViewById(R.id.answerB);
        RadioButton radioButtonC = (RadioButton) findViewById(R.id.answerC);
        RadioButton radioButtonD = (RadioButton) findViewById(R.id.answerD);

        radioButtonA.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        Log.d("DEBUG", "in case A");
                        String answerA = questionSet.getAnswerSet().getA();
                        if (answerA.equals(correctAnswer))
                        {
                            numCorrect++;
                            Log.d("DEBUG", "NUMBER OF CORRECT ANSWERED: " + numCorrect);
                            openQuestion_Result_Activity(true, factText);
                        }
                        else
                            {
                                openQuestion_Result_Activity(false, factText);
                            }
                    }
                });
        radioButtonB.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        Log.d("DEBUG", "in case B");
                        String answerB = questionSet.getAnswerSet().getB();
                        if (answerB.equals(correctAnswer))
                        {
                            numCorrect++;
                            Log.d("DEBUG", "NUMBER OF CORRECT ANSWERED: " + numCorrect);
                            openQuestion_Result_Activity(true, factText);
                        }
                        else
                        {
                            openQuestion_Result_Activity(false, factText);
                        }
                    }
                });
        radioButtonC.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        Log.d("DEBUG", "in case A");
                        String answerC = questionSet.getAnswerSet().getC();
                        if (answerC.equals(correctAnswer))
                        {
                            numCorrect++;
                            Log.d("DEBUG", "NUMBER OF CORRECT ANSWERED: " + numCorrect);
                            openQuestion_Result_Activity(true, factText);
                        }
                        else
                        {
                            openQuestion_Result_Activity(false, factText);
                        }
                    }
                });
        radioButtonD.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        Log.d("DEBUG", "in case A");
                        String answerD = questionSet.getAnswerSet().getD();
                        if (answerD.equals(correctAnswer))
                        {
                            numCorrect++;
                            Log.d("DEBUG", "NUMBER OF CORRECT ANSWERED: " + numCorrect);
                            openQuestion_Result_Activity(true, factText);
                        }
                        else
                        {
                            openQuestion_Result_Activity(false, factText);
                        }
                    }
                }
        );
    }
}
