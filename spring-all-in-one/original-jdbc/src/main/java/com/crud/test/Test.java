package com.crud.test;

import com.crud.service.JdbcService;
import com.crud.dto.Word;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) throws Exception {
        JdbcService jdbc = new JdbcService();

        // queryAll
        ArrayList<Word> words =  jdbc.queryAll();
        for(Word w : words) {
            System.out.println(w.getChinese());
        }

        // queryOne
        Word word =  jdbc.queryOne(3);
        System.out.println(word.getChinese());

        // insertOne
        Word insertWord = new Word(0, "insert", "插入");
        jdbc.insertOne(insertWord);

        // updateOne
        Word updatetWord = new Word(9, "insert", "插入");
        jdbc.updateOne(updatetWord);

        // deleteOne
        jdbc.deleteOne(9);

        // queryByPage
        ArrayList<Word> pageWord = jdbc.queryByPage(3,2);
        for(Word w : pageWord) {
            System.out.println(w.getId());
        }

    }
}
