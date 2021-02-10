package com.id2216g5.androidapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.LinearLayout;
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
        TextView placeholder1 = findViewById(R.id.midgameUserPlcaceholder1);
        TextView placeholder2 = findViewById(R.id.midgameUserPlcaceholder2);
        TextView placeholder3 = findViewById(R.id.midgameUserPlcaceholder3);

        round.append(String.valueOf(game.getRound()));

        StringBuilder sb = new StringBuilder();
        game.getPlayingPlayers().stream().forEach(player -> sb.append(player + "\n"));
        placeholder1.setText(sb.toString());

        new CountDownTimer(5000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                nextQuestion(game);
            }
        }.start();


        /*
        placeholder2.setText("");
        placeholder3.setText("");
        switch(status) {
            case "case1":
                plcaceholder1.setText("Rille");
                plcaceholder3.setText("user");
                break;
            case "case2":
                plcaceholder1.setText("user");
                plcaceholder3.setText("Rille");
                break;
            default:
                plcaceholder1.setText("Rille");
                plcaceholder2.setText("user");
        }
        */
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    void nextQuestion(QuizGame game) {
        game.nextRound();
        Intent intent = new Intent(this, QuestionScreenActivity.class);
        intent.putExtra("game", game);
        startActivity(intent);
    }
}