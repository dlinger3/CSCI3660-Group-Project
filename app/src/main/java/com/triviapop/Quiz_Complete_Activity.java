package com.triviapop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Quiz_Complete_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_complete_activity);

        Bundle savedData = getIntent().getExtras();
        int numCorrect = savedData.getInt("correct");
        Log.d("DEBUG", "NUMBER CORRECT RECEIVED AT FINAL ACTIVITY: " + numCorrect);

        TextView percentCorrectView = findViewById(R.id.percent_correct_view);
        AppCompatButton toMenuButton = (AppCompatButton) findViewById(R.id.return_to_menu);
        String percentCorrectText = "You answered " + numCorrect + "% of the questions correctly.";
        percentCorrectView.setText(percentCorrectText);
        scanForReturn(toMenuButton);

    }

    private void scanForReturn(AppCompatButton toMenuButton) {
        toMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Quiz_Complete_Activity.this,MainActivity.class);
                intent.putExtra("returnedToMenu", true);
                finish();
                startActivity(intent);
            }
        });
    }
}
