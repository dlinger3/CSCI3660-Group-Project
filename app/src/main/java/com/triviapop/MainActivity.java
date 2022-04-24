package com.triviapop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes

public class MainActivity extends AppCompatActivity {

    private Button his_button;
    private Button ent_button;
    private Button sci_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        his_button = (Button) findViewById(R.id.history_button);
        his_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openQuiz_Activity();
            }
        });

        ent_button = (Button) findViewById(R.id.entertainment_button);
        ent_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openQuiz_Activity();
            }
        });

        sci_button = (Button) findViewById(R.id.science_button);
        sci_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openQuiz_Activity();
            }
        });
    }
    public void openQuiz_Activity() {
        Intent intent = new Intent(this, Quiz_Activity.class);
        startActivity(intent);
    }

}


//    private int questionCount = 0;
//    String[] questionLabels;
//    HashSet<Questions> questionSet = new HashSet<Questions>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Resources resource = getResources();
//        questionLabels = resource.getStringArray(R.array.question_count);
//        TextView currentQuestionLabel = findViewById(R.id.question_number_text_view);
//        currentQuestionLabel.setText(questionLabels[questionCount]);
//
//        for(Questions currQuestion : questionSet)
//        {
//            currentQuestionLabel.setText(questionLabels[questionCount++]);
//        }
//        //TODO read questions from file/database
//        //TODO create logic to loop while populating the HashSet randomly with question objects from the read in file.
//    }