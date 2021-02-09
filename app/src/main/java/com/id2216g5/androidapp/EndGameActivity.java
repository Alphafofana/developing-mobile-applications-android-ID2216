package com.id2216g5.androidapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class EndGameActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        TextView winnerNameView = findViewById(R.id.endScreenWinnerName);
        TextView eliminatedNameView = findViewById(R.id.endScreenEliminatedUsers);
        /* Expecting intent from previous screen
        Intent intent = getIntent();
        String winningUser = intent.getStringExtra();
        List<String> eliminatedUsers = intent.getStringArrayListExtra();
        winnerNameView.setText(winningUser);
        eliminatedUsers.stream().forEach(user -> eliminatedNameView.append(user + '\n'));
         */
        winnerNameView.setText("Rillmeister");
        eliminatedNameView.setText("user\nuser2\n");
    }

    public void backButton(View view) {
        startActivity(new Intent(this, LobbyActivity.class));
    }
}