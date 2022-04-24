package com.triviapop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
<<<<<<< Updated upstream
=======
import android.widget.TextView;
>>>>>>> Stashed changes

public class Question_Result_Activity extends AppCompatActivity {

    private Button nextQuestion;

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
<<<<<<< Updated upstream
=======
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
>>>>>>> Stashed changes

        nextQuestion = (Button) findViewById(R.id.next_question_button);
        //TODO This needs to instead load the quiz_activity layout, populated with the question set data for the next question
        nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openQuiz_Complete();
            }
        });
    }

    public void nextq(View view) {
        startActivity(new Intent(Question_Result_Activity.this, Quiz_Activity.class));
    }
    public void openQuiz_Complete() {
        Intent intent = new Intent(this, Quiz_Complete_Activity.class);
        startActivity(intent);
    }
}