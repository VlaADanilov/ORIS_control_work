package db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConfig {
    private static final String URL = "jdbc:postgresql://localhost:5432/oris";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";
    private static final String DRIVER = "org.postgresql.Driver";
    private static final int MAX_POOL_SIZE = 20;
    private HikariConfig config;

    private HikariDataSource dataSource;

    public DataBaseConfig(){
        initHikariConfig();
        dataSource = new HikariDataSource(config);
    }

    private void initHikariConfig(){
        try {
            config = new HikariConfig();
            config.setDriverClassName(DRIVER);
            config.setJdbcUrl(URL);
            config.setUsername(USERNAME);
            config.setPassword(PASSWORD);
            config.setMaximumPoolSize(MAX_POOL_SIZE);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        try {
            return dataSource.getConnection();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    public void close(){
        dataSource.close();
    }
}
