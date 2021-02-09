package com.id2216g5.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class QuestionScreenActivity extends AppCompatActivity {
    public static final String WINNER_MESSAGE = "com.id2216g5.androidapp.WON";

    private Button alternativeOne;
    private Button alternativeTwo;
    private Button alternativeThree;
    private Button alternativeFour;

    boolean won;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_screen);

        /* Bind the XML views to Java Code Elements */
        alternativeOne = findViewById(R.id.alternativeOne);
        alternativeTwo = findViewById(R.id.alternativeTwo);
        alternativeThree = findViewById(R.id.alternativeThree);
        alternativeFour = findViewById(R.id.alternativeFour);

        alternativeOne.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                won = false;
                startEndScreenActivity();
            }
        });

        alternativeTwo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                won = true;
                startEndScreenActivity();
            }
        });

        alternativeThree.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                won = false;
                startEndScreenActivity();
            }
        });

        alternativeFour.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                won = false;
                startEndScreenActivity();
            }
        });
    }


    void startEndScreenActivity(){

        Intent intent = new Intent(this, EndGameActivity.class);
        intent.putExtra(WINNER_MESSAGE, won);
        startActivity(intent);

    }
}