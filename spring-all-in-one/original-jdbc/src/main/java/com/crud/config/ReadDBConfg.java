package com.crud.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ReadDBConfg {

    private Map<String, String> configMap = new HashMap<String, String>();

    public ReadDBConfg(String filename) throws IOException {
        readJdbcProperties(filename);
    }

    private void readJdbcProperties(String filename) throws IOException {
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream(filename);
        Properties properties = new Properties();
        properties.load(stream);
        configMap.put("user", properties.getProperty("jdbc.user"));
        configMap.put("password", properties.getProperty("jdbc.password"));
        configMap.put("url", properties.getProperty("jdbc.url"));
        configMap.put("driver", properties.getProperty("jdbc.driver"));
        stream.close();
    }

    public String getConfig (String config) {
        return configMap.get(config);
    }
}
