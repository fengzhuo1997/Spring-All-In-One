package com.crud.service;

import com.crud.dto.Word;
import com.crud.config.ReadDBConfg;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class JdbcService {
    private Statement statement;

    public JdbcService() throws IOException, ClassNotFoundException, SQLException {
        ReadDBConfg conf = new ReadDBConfg("jdbc.properties");
        String user = conf.getConfig("user");
        String pwd = conf.getConfig("password");
        String url = conf.getConfig("url");
        String driver = conf.getConfig("driver");
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, user, pwd);
        statement = con.createStatement();
    }

    public ArrayList<Word> queryAll() throws SQLException {
        ArrayList<Word> words = new ArrayList<>();
        String sql = "select * from words";
        ResultSet set = statement.executeQuery(sql);
        while(set.next()) {
            Word word = new Word(set.getInt("id"), set.getString("word"), set.getString("chinese"));
            words.add(word);
        }
        return words;
    }

    public Word queryOne(int id) throws SQLException {
        Word word = new Word();
        String sql = "select * from words where id = " + Integer.toString(id);
        ResultSet set = statement.executeQuery(sql);
        while(set.next()) {
            word = new Word(set.getInt("id"), set.getString("word"), set.getString("chinese"));
        }
        return word;
    }

    public void insertOne(Word w) throws SQLException {
        String word = w.getWord();
        String chinese = w.getChinese();
        String sql = "insert into words (word, chinese) values ('" + word + "','" + chinese  + "');";
        statement.execute(sql);
    }

    public void updateOne(Word w) throws SQLException {
        int id = w.getId();
        String word = w.getWord();
        String chinese = w.getChinese();
        String sql = "update words set word='" + word + "', chinese='" + chinese + "' where id='" + id + "'";
        statement.execute(sql);
    }

    public void deleteOne(int id) throws SQLException {
        String sql = "delete from words where id = " + id;
        statement.execute(sql);
    }

    // 分页查询
    public ArrayList<Word> queryByPage(int size, int page) throws Exception {
        if(size < 0 || page < 0) {
            throw new Exception("Please enter the correct conditions.");
        }
        ArrayList<Word> words = new ArrayList<>();
        int lastMax = (page - 1) * size;
        String sql = "select * from words order by id limit " + Integer.toString(lastMax) + "," + Integer.toString(size) + ";";
        ResultSet set = statement.executeQuery(sql);
        while(set.next()) {
            Word word = new Word(set.getInt("id"), set.getString("word"), set.getString("chinese"));
            words.add(word);
        }
        if(words.size() == 0) {
            throw new Exception("Non existing data, please re-enter the conditions.");
        }
        return words;
    }


}
