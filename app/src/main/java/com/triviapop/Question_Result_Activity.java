package com.triviapop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.triviapop.questProcessing.QuestionSet;

public class Question_Result_Activity extends AppCompatActivity {

    private static final int NUMBER_QUESTIONS_IN_QUIZ = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_result_activity);

        Button nextQuestion = (Button) findViewById(R.id.next_question_button);
        TextView resultText = (TextView) findViewById(R.id.question_result) ;
        TextView factText = (TextView) findViewById(R.id.question_fact_text);
        Bundle savedData = getIntent().getExtras();
        int count = savedData.getInt("count");
        boolean wasCorrect = savedData.getBoolean("result");
        String fact = savedData.getString("fact");

        String result = "";
        if(wasCorrect)
        {
            result = "Correct Answer!";
            resultText.setText(result);
        }
        else
        {
            result = "Wrong Answer";
            resultText.setText(result);
        }
        factText.setText(fact);

//        scanForClick(nextQuestion, count);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.question_result_activity);
        Log.d("DEBUG", "on resume called in results");

        Button nextQuestion = (Button) findViewById(R.id.next_question_button);
        TextView resultText = (TextView) findViewById(R.id.question_result) ;
        TextView factText = (TextView) findViewById(R.id.question_fact_text);
        Bundle savedData = getIntent().getExtras();
        int count = savedData.getInt("count");
        boolean wasCorrect = savedData.getBoolean("result");
        String fact = savedData.getString("fact");
        int numCorrect = savedData.getInt("correct");

        String result = "";
        if(wasCorrect)
        {
            result = "Correct Answer!";
            resultText.setText(result);
        }
        else
        {
            result = "Wrong Answer";
            resultText.setText(result);
        }
        factText.setText(fact);

        scanForClick(nextQuestion, count, numCorrect);
    }

    @Override
    protected void onPause() {

        super.onPause();
    }

    private void scanForClick(Button nextQuestion, int count, int numCorrect) {
        nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count >= NUMBER_QUESTIONS_IN_QUIZ)
                {
                    int percentCorrect = calculatePercentCorrect(numCorrect);
                    openQuiz_Complete(percentCorrect);
                }
                else
                {
                    finish();
                }
            }
        });
    }

    private void openQuiz_Complete(int numCorrect) {
        Log.d("DEBUG", "NUMBER CORRECT PASSED TO THE FINAL INTENT CALL: " + numCorrect);
        Intent intent = new Intent(this, Quiz_Complete_Activity.class);
        intent.putExtra("correct", numCorrect);
        startActivity(intent);

    }

    private int calculatePercentCorrect(int numCorrect)
    {

        int percentCorrect = (int)(((double) numCorrect / (double) NUMBER_QUESTIONS_IN_QUIZ) * 100);
        Log.d("DEBUG","NUMBER OF CORRECT ANSWERS TO DISPLAY: " + percentCorrect);
        return percentCorrect;
    }
}