package com.id2216g5.androidapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import model.QuizGame;

public class QuestionScreenActivity extends AppCompatActivity {
    public static final String WINNER_MESSAGE = "com.id2216g5.androidapp.WON";

    private Button alternativeOne;
    private Button alternativeTwo;
    private Button alternativeThree;
    private Button alternativeFour;
    private TextView questionText;

    @Override
    @RequiresApi(api = Build.VERSION_CODES.N)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_screen);

        /* Bind the XML views to Java Code Elements */
        alternativeOne = findViewById(R.id.alternativeOne);
        alternativeTwo = findViewById(R.id.alternativeTwo);
        alternativeThree = findViewById(R.id.alternativeThree);
        alternativeFour = findViewById(R.id.alternativeFour);
        questionText = findViewById(R.id.questionText);

        QuizGame game = (QuizGame) getIntent().getSerializableExtra("game");

        alternativeOne.setText(game.getCurrentQuestion().getWrongAnswers().get(0));
        alternativeTwo.setText(game.getCurrentQuestion().getCorrectAnswer());
        alternativeThree.setText(game.getCurrentQuestion().getWrongAnswers().get(1));
        alternativeFour.setText(game.getCurrentQuestion().getWrongAnswers().get(2));
        questionText.setText(game.getCurrentQuestion().getQuestion());

        alternativeOne.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                playerLose(game);
            }
        });

        alternativeTwo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                playerWin(game);
            }
        });

        alternativeThree.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                playerLose(game);
            }
        });

        alternativeFour.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                playerLose(game);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    void playerLose(QuizGame game) {
        game.addKnockedOutPlayer("user");
        startEndScreenActivity(game);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    void playerWin(QuizGame game) {
        if(game.getRound() == 2) {
            game.addKnockedOutPlayer("Rillmeister");
            startEndScreenActivity(game);
        } else {
            startMidScreenActivity(game);
        }

    }

    void startEndScreenActivity(QuizGame game){

        Intent intent = new Intent(this, EndGameActivity.class);
        intent.putExtra("game", game);
        startActivity(intent);

    }

    void startMidScreenActivity(QuizGame game) {
        Intent intent = new Intent(this, MidGame.class);
        intent.putExtra("game", game);
        startActivity(intent);

    }
}