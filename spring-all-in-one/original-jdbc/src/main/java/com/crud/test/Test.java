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
        Word updatetWord = new Word(12, "add", "添加");
        int res = jdbc.updateOne(updatetWord);
        System.out.println(res);

        // deleteOne
        jdbc.deleteOne(13);

        // queryByPage
        ArrayList<Word> pageWord = jdbc.queryByPage(3,2);
        for(Word w : pageWord) {
            System.out.println(w.getId());
        }

    }
}
