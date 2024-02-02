package com.servlet.web.dto;

public class Word {

    private int id;

    private String word;

    private String chinese;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public Word(int id, String word, String chinese) {
        this.id = id;
        this.word = word;
        this.chinese = chinese;
    }

    public Word() {}
}
