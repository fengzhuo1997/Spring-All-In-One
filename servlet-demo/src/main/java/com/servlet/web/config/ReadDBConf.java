package com.servlet.web.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import jakarta.servlet.http.HttpServlet;

public class ReadDBConf extends HttpServlet {

    private Map<String, String> configMap = new HashMap<String, String>();

    public ReadDBConf(String filename) throws IOException {
        readJdbcProperties(filename);
    }

    private void readJdbcProperties(String filename) throws IOException {
    	
//    	InputStream stream = this.getClass().getClassLoader().getResourceAsStream(filename);
//        Properties properties = new Properties();
//        properties.load(stream);
//        configMap.put("user", properties.getProperty("jdbc.user"));
//        configMap.put("password", properties.getProperty("jdbc.password"));
//        configMap.put("url", properties.getProperty("jdbc.url"));
//        configMap.put("driver", properties.getProperty("jdbc.driver"));
//        stream.close();
    	
    	configMap.put("user", "root");
    	configMap.put("password", "my-secret-pw");
    	configMap.put("url", "jdbc:mysql://localhost:3306/sys?characterEncoding=utf-8&userSSL=false");
    	configMap.put("driver", "com.mysql.cj.jdbc.Driver");
    }

    public String getConfig (String config) {
        return configMap.get(config);
    }
}
