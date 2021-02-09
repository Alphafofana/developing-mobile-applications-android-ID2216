package model;

import java.util.List;

public class QuizQuestion {
    private String question;
    private String correctAnswer;
    private List<String> wrongAnswers;

    public QuizQuestion() {
    }

    public QuizQuestion(String question, String correctAnswer, List<String> wrongAnswers) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.wrongAnswers = wrongAnswers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public List<String> getWrongAnswers() {
        return wrongAnswers;
    }

    public void setWrongAnswers(List<String> wrongAnswers) {
        this.wrongAnswers = wrongAnswers;
    }

    public boolean checkAnswer(String answer) {
        return answer.equals(correctAnswer);
    }
}
