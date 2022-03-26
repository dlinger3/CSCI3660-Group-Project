package com.triviapop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Quiz_Complete_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_complete_activity);
    }

    public void returnmain(View view) {
        startActivity(new Intent(Quiz_Complete_Activity.this, MainActivity.class));
    }
}
