package com.crud.service;

import com.crud.dto.Word;
import com.crud.utils.DbUtil;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class JdbcService {
    public ArrayList<Word> queryAll() throws SQLException, IOException, ClassNotFoundException {
        ArrayList<Word> words = new ArrayList<>();
        String sql = "select * from words";
        DbUtil dbUtil = new DbUtil();
        Connection conn = dbUtil.getConnection("jdbc.properties");
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()) {
            Word word = new Word(rs.getInt("id"), rs.getString("word"), rs.getString("chinese"));
            words.add(word);
        }
        conn.close();
        stmt.close();
        rs.close();
        return words;
    }

    public Word queryOne(int id) throws SQLException, IOException, ClassNotFoundException {
        Word word = new Word();
        String sql = "select * from words where id = ?";
        DbUtil dbUtil = new DbUtil();
        Connection conn = dbUtil.getConnection("jdbc.properties");
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, Integer.toString(id));
        ResultSet rs = stmt.executeQuery();
        while(rs.next()) {
            word = new Word(rs.getInt("id"), rs.getString("word"), rs.getString("chinese"));
        }
        conn.close();
        stmt.close();
        rs.close();
        return word;
    }

    public void insertOne(Word w) throws SQLException, IOException, ClassNotFoundException {
        String word = w.getWord();
        String chinese = w.getChinese();
        String sql = "insert into words (word, chinese) values (?, ?);";
        DbUtil dbUtil = new DbUtil();
        Connection conn = dbUtil.getConnection("jdbc.properties");
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, word);
        stmt.setString(2, chinese);
        stmt.execute();
        conn.close();
        stmt.close();
    }

    public int updateOne(Word w) throws SQLException, IOException, ClassNotFoundException {
        int id = w.getId();
        String word = w.getWord();
        String chinese = w.getChinese();
        String sql = "update words set word=?, chinese=? where id=?";
        DbUtil dbUtil = new DbUtil();
        Connection conn = dbUtil.getConnection("jdbc.properties");
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, word);
        stmt.setString(2, chinese);
        stmt.setInt(3, id);
        int res = stmt.executeUpdate();
        conn.close();
        stmt.close();
        return res;
    }

    public void deleteOne(int id) throws SQLException, IOException, ClassNotFoundException {
        String sql = "delete from words where id = ?";
        DbUtil dbUtil = new DbUtil();
        Connection conn = dbUtil.getConnection("jdbc.properties");
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.execute();
        conn.close();
        stmt.close();
    }

    // 分页查询
    public ArrayList<Word> queryByPage(int size, int page) throws Exception {
        if(size < 0 || page < 0) {
            throw new Exception("Please enter the correct conditions.");
        }
        ArrayList<Word> words = new ArrayList<>();
        int lastMax = (page - 1) * size;
        String sql = "select * from words order by id limit ?,?";
        DbUtil dbUtil = new DbUtil();
        Connection conn = dbUtil.getConnection("jdbc.properties");
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, lastMax);
        stmt.setInt(2, size);
        ResultSet set = stmt.executeQuery();
        while(set.next()) {
            Word word = new Word(set.getInt("id"), set.getString("word"), set.getString("chinese"));
            words.add(word);
        }
        conn.close();
        stmt.close();
        if(words.size() == 0) {
            throw new Exception("Non existing data, please re-enter the conditions.");
        }
        return words;
    }


}
