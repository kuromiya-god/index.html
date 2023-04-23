package model;

public class Choice {
    private int id;            // 選択肢のID
    private String text;      // 選択肢のテキスト

    public Choice(int id, String text) {
        this.id = id;
        this.text = text;
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
}