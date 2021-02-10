package model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuizGame {

    private List<QuizQuestion> questions;
    private List<String> playingPlayers;
    private List<String> knockedOutPlayers;
    private List<String> knockedOutLastRound;
    private int round;
    private boolean over;

    public QuizGame() {
        this.round = 1;
        this.over = false;
    }

    public QuizGame(List<QuizQuestion> questions, List<String> playingPlayers) {
        this.questions = questions;
        this.playingPlayers = playingPlayers;
        this.knockedOutPlayers = new ArrayList<>();
        this.knockedOutLastRound = new ArrayList<>();
        this.round = 1;
        this.over = false;
    }

    public List<QuizQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuizQuestion> questions) {
        this.questions = questions;
    }

    public List<String> getPlayingPlayers() {
        return playingPlayers;
    }

    public void setPlayingPlayers(List<String> playingPlayers) {
        this.playingPlayers = playingPlayers;
    }

    public List<String> getKnockedOutPlayers() {
        return knockedOutPlayers;
    }

    public List<String> getKnockedOutLastRound() {
        return knockedOutLastRound;
    }

    public QuizQuestion getCurrentQuestion() {
        return questions.get(round - 1);
    }

    public boolean isOver() {
        return over;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void addKnockedOutPlayer(String knockedOutPlayer) {
        playingPlayers = playingPlayers.stream().filter(player -> !player.equals(knockedOutPlayer)).collect(Collectors.toList());
        knockedOutLastRound.add(knockedOutPlayer);
        over = !playingPlayers.isEmpty();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void nextRound() {
        knockedOutPlayers.addAll(knockedOutLastRound);
        knockedOutLastRound = new ArrayList<>();
        round++;
    }


}
