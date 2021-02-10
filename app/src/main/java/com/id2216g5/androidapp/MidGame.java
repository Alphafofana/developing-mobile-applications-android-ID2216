package com.id2216g5.androidapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ProgressBar;
import android.widget.TextView;

import model.QuizGame;

public class MidGame extends AppCompatActivity {
    String status = "";


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_midgame);

        QuizGame game = (QuizGame) getIntent().getSerializableExtra("game");

        TextView round = findViewById(R.id.midgameHeading);
        TextView alivePlaceholder = findViewById(R.id.midgameAlivePlcaceholder);
        TextView eliminatedPlaceholder = findViewById(R.id.midgameEliminatedPlcaceholder);
        ProgressBar progressBar= (ProgressBar)findViewById(R.id.midgameprogressBar);

        round.append(String.valueOf(game.getRound()));

        StringBuilder sb = new StringBuilder();
        game.getPlayingPlayers().stream().forEach(player -> sb.append(player + "\n"));
        alivePlaceholder.setText(sb.toString());

        new CountDownTimer(10000, 1) {

            @Override
            public void onTick(long millisUntilFinished) {
                progressBar.setProgress((int)millisUntilFinished/100);
            }

            @Override
            public void onFinish() {
                nextQuestion(game);
            }
        }.start();

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    void nextQuestion(QuizGame game) {
        game.nextRound();
        Intent intent = new Intent(this, QuestionScreenActivity.class);
        intent.putExtra("game", game);
        startActivity(intent);
    }
}