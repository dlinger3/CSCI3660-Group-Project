package com.triviapop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private String SUBJECT = "subject";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button his_button, ent_button, sci_button;


        his_button = (Button) findViewById(R.id.history_button);
        his_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selection = "History";
                openQuiz_Activity(selection);
            }
        });

        ent_button = (Button) findViewById(R.id.entertainment_button);
        ent_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selection = "Entertainment";
                openQuiz_Activity(selection);
            }
        });

        sci_button = (Button) findViewById(R.id.science_button);
        sci_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selection = "Science";
                openQuiz_Activity(selection);
            }
        });
    }



    public void openQuiz_Activity(String selection) {
        Intent intent = new Intent(this, Quiz_Activity.class);
        Bundle subjectData = new Bundle();
        subjectData.putString("subject", selection);
        intent.putExtras(subjectData);
//        intent.putExtra(SUBJECT, selection);
        startActivity(intent);
    }


}