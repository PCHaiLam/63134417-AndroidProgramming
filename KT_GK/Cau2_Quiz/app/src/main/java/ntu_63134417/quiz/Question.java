package ntu_63134417.quiz;

import java.util.List;

public class Question {
    private String question;
    private List<String> options;
    private String correctAnswer;

    public Question(String questionText, List<String> options, String correctAnswer) {
        this.question = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
