package com.triviapop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//TODO I have also not done anything with the themes.xml files. Not necessarily needed (as far as I know) but feel free to implement them
//TODO TEST TEST TEST TEST. Please test this, try to break it. Check for spelling errors in the text. Check that the answers are paired correctly to the documents in the google drive
//TODO If you want to implement additional features, you have probably the rest of this week and possibly next.

//TODO ::::::::::::::::::::::THE FOLLOWING IS STILL NEEDED FOR BASE REQUIREMENTS::::::::::::::::::::::::::::::::::::::::::
//  still need to add unique graphics for the subjects - possibly can use android studio built in vector art.
//  add questions/answer sets/facts for the Entertainment and Science subjects until there are 20 questions in each. Please add to drive documents first following the format already there (correct answers are highlighted)
//  add app launcher logo to mipmap folder
//  there are possibly some other things as well but this is what I am aware of at the moment.

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