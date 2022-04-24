package com.triviapop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Question_Result_Activity extends AppCompatActivity {

    private static final int NUMBER_QUESTIONS_IN_QUIZ = 10;
    private static int count;
    private static int numCorrect;

    /**
     * Builds the result screen after a quiz question is answered by the user.
     * @param savedInstanceState a bundle of the data needed for this activity.
     *                           keys
     *                           result: a boolean for if the user answered correctly or not
     *                           fact: the fact text that will be displayed
     *                           correct: an update of the number of correctly answered questions
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.question_result_activity);
        Log.d("DEBUG", "on resume called in results");

        Button nextQuestion = (Button) findViewById(R.id.next_question_button);
        TextView resultText = (TextView) findViewById(R.id.question_result) ;
        TextView factText = (TextView) findViewById(R.id.question_fact_text);
        Bundle savedData = getIntent().getExtras();
        count = savedData.getInt("count");
        count++;
        boolean wasCorrect = savedData.getBoolean("result");
        String fact = savedData.getString("fact");
        numCorrect = savedData.getInt("correct");

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
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.question_result_activity);
        Log.d("DEBUG", "on resume called in results");

        Button nextQuestion = (Button) findViewById(R.id.next_question_button);
        TextView resultText = (TextView) findViewById(R.id.question_result) ;
        TextView factText = (TextView) findViewById(R.id.question_fact_text);
        Bundle savedData = getIntent().getExtras();
        count = savedData.getInt("count");
        count++;
        boolean wasCorrect = savedData.getBoolean("result");
        String fact = savedData.getString("fact");
        numCorrect = savedData.getInt("correct");

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
    public void onBackPressed()
    {
        super.onBackPressed();
        if(count >= NUMBER_QUESTIONS_IN_QUIZ)
        {
            int percentCorrect = calculatePercentCorrect(numCorrect);
            openQuiz_Complete(percentCorrect);
        }
        else
        {
            returnToQuiz(numCorrect, count);
        }
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
                    returnToQuiz(numCorrect, count);
                }
            }
        });
    }

    private void openQuiz_Complete(int numCorrect) {
        Log.d("DEBUG", "NUMBER CORRECT PASSED TO THE FINAL INTENT CALL: " + numCorrect);
        Intent intent = new Intent(this, Quiz_Complete_Activity.class);

        intent.putExtra("correct", numCorrect);
        startActivity(intent);
        finish();

    }

    private void returnToQuiz(int numCorrect, int count)
    {
        Log.d("DEBUG", "NUMBER CORRECT BEING PASSED BACK TO QUIZ " + numCorrect);
        Log.d("DEBUG", "COUNT BEING PASSED BACK TO QUIZ : " + count);
        Intent intent = new Intent(this, Quiz_Activity.class);
        intent.putExtra("correct", numCorrect);
        intent.putExtra("count", count);
        Log.d("DEBUG", "Returning to quiz...");
        startActivity(intent);
        finish();
    }

    private int calculatePercentCorrect(int numCorrect)
    {

        int percentCorrect = (int)(((double) numCorrect / (double) NUMBER_QUESTIONS_IN_QUIZ) * 100);
        Log.d("DEBUG","NUMBER OF CORRECT ANSWERS TO DISPLAY: " + percentCorrect);
        return percentCorrect;
    }
}