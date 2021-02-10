package com.id2216g5.androidapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import model.QuizGame;

public class EndGameActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        TextView winnerNameView = findViewById(R.id.endScreenWinnerName);
        TextView eliminatedNameView = findViewById(R.id.endScreenEliminatedUsers);
        QuizGame game = (QuizGame) getIntent().getSerializableExtra("game");

        //Hårdkodat hack
        winnerNameView.setText(game.getPlayingPlayers().get(0));
        StringBuilder sb = new StringBuilder();
        game.getKnockedOutPlayers().stream().forEach(player -> sb.append(player + '\n'));
        game.getKnockedOutLastRound().stream().forEach(player -> sb.append(player + '\n'));
        eliminatedNameView.setText(sb.toString());
    }

    public void backButton(View view) {
        startActivity(new Intent(this, LobbyActivity.class));
    }
}