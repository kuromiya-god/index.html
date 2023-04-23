package model;

import java.util.List;

public class Question {
    private int id;                  // 問題のID
    private String text;             // 問題文
    private List<Choice> choices;    // 選択肢のリスト
    private int answer;              // 正解の選択肢の番号

    public Question(int id, String text, List<Choice> choices, int answer) {
        this.id = id;
        this.text = text;
        this.choices = choices;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
