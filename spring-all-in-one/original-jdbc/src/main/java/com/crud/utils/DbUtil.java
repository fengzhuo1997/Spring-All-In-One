package com.crud.utils;

import com.crud.config.ReadDBConfg;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {

    public Connection getConnection(String configFile) throws IOException, ClassNotFoundException, SQLException {
        ReadDBConfg conf = new ReadDBConfg(configFile);
        String user = conf.getConfig("user");
        String pwd = conf.getConfig("password");
        String url = conf.getConfig("url");
        String driver = conf.getConfig("driver");
        Class.forName(driver);
        return DriverManager.getConnection(url, user, pwd);
    }
}
