package com.triviapop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz_Activity extends AppCompatActivity {

    private Button button_result;

    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView questionText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Quiz_Activity", "Entered new activity.");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_activity);
        radioGroup = findViewById(R.id.answer_group); //Grabs the radio group
        questionText = findViewById(R.id.question_text);  //Grabs the question

//        Button buttonsubmit = findViewById(R.id.button_submit);
//        buttonsubmit.setOnClickListener(new View.OnClickListener())

        AppCompatButton returnToMenuButton = findViewById(R.id.return_to_menu);
        returnToMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returntomenu(view);
            }
        });


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id)
            {
                switch (id)
                {
                    case R.id.answerA:
                        openQuestion_Result_Activity();
                        break;
                    case R.id.answerB:
                        openQuestion_Result_Activity();
                        break;
                    case R.id.answerC:
                        openQuestion_Result_Activity();
                        break;
                    case R.id.answerD:
                        openQuestion_Result_Activity();
                        break;
                }

            }
        });
//        {
//            @Override
//            public void onClick(View view) {
//                int radioID = radioGroup.getCheckedRadioButtonId();
//
//                radioButton = findViewById(radioID);
//
//                questionText.setText("Result: " + radioButton.getText());
//            }
//        });
    }

    public void checkButton(View v) {
        int radioID = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioID);

        Toast.makeText(this, "Selected Radio Button: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
    }

    public void returntomenu(View view) {
        startActivity(new Intent(Quiz_Activity.this,MainActivity.class));
    }
    public void openQuestion_Result_Activity() {
        Intent intent = new Intent(this, Question_Result_Activity.class);
        startActivity(intent);
    }
}
