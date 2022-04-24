package com.triviapop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sets up the buttons and passes the user's subject selection to the quiz activity
        scanForClick();

    }

    @Override
    protected void onResume() {

        super.onResume();
        setContentView(R.layout.activity_main);

        //Sets up the buttons and passes the user's subject selection to the quiz activity
        scanForClick();

    }


    private void openQuiz_Activity(String selection) {
        Intent intent = new Intent(this, Quiz_Activity.class);
        Bundle subjectData = new Bundle();
        subjectData.putString("subject", selection);
        intent.putExtras(subjectData);
//        intent.putExtra(SUBJECT, selection);
        startActivity(intent);
    }

    /**
     * Sets up the buttons and passes the user's subject selection to the quiz activity
     * This function is called when this activity is
     */
    private void scanForClick()
    {
        //Variables for the subject buttons
        Button his_button, ent_button, sci_button, exit_button;

        //Gets the history button view and sets its event listener
        his_button = (Button) findViewById(R.id.history_button);
        his_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selection = "History";
                openQuiz_Activity(selection);
            }
        });

        //Gets the entertainment button view and sets its event listener
        ent_button = (Button) findViewById(R.id.entertainment_button);
        ent_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selection = "Entertainment";
                openQuiz_Activity(selection);
            }
        });

        //Gets the science button view and sets its event listener
        sci_button = (Button) findViewById(R.id.science_button);
        sci_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selection = "Science";
                openQuiz_Activity(selection);
            }
        });

        exit_button = (Button) findViewById(R.id.exit_button);
        exit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });
    }


}