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
    private HikariConfig config;

    private HikariDataSource dataSource;

    public DataBaseConfig(){
        initHikariConfig();
        dataSource = new HikariDataSource(config);
    }

    private void initHikariConfig(){
        try {
            Properties prop = new Properties();
            File file = new File("src/main/resources/database.properties");
            System.out.println(file.getAbsolutePath());
            prop.load(new FileReader("src/main/resources/database.properties"));
            config = new HikariConfig();
            config.setDriverClassName(prop.getProperty("db.driver"));
            config.setJdbcUrl(prop.getProperty("db.url"));
            config.setUsername(prop.getProperty("db.username"));
            config.setPassword(prop.getProperty("db.password"));
            config.setMaximumPoolSize(Integer.parseInt(prop.getProperty("db.max_pool_size")));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void close(){
        dataSource.close();
    }
}
