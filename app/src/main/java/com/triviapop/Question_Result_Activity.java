package com.triviapop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Question_Result_Activity extends AppCompatActivity {

    private Button nextQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_result_activity);

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