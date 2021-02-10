package com.id2216g5.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Arrays;

import model.QuizGame;
import model.QuizQuestion;

public class LobbyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);
    }

    public void joinGame(View view) {
        QuizGame game = new QuizGame();
        game.setPlayingPlayers(Arrays.asList("user", "Rillmeister"));
        QuizQuestion q1 = new QuizQuestion("Which fruit is yellow?",
                "Banana",
                Arrays.asList("Orange", "Pear", "Grape"));
        QuizQuestion q2 = new QuizQuestion("Which fruit is orange?",
                "Orange",
                Arrays.asList("Banana", "Pear", "Grape"));
        game.setQuestions(Arrays.asList(q1, q2));


        Intent intent = new Intent(this, QuestionScreenActivity.class);
        intent.putExtra("game", game);
        startActivity(intent);
    }
}