package com.servlet.web.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.servlet.web.config.ReadDBConf;

public class DbUtil {

    public Connection getConnection(String configFile) throws IOException, ClassNotFoundException, SQLException {
        ReadDBConf conf = new ReadDBConf(configFile);
        String user = conf.getConfig("user");
        String pwd = conf.getConfig("password");
        String url = conf.getConfig("url");
        String driver = conf.getConfig("driver");
        Class.forName(driver);
        return DriverManager.getConnection(url, user, pwd);
    }
}
