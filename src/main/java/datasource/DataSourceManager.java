package datasource;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Gaidin on 12.11.2017.
 */
public class DataSourceManager {
    private static String configPath = "src\\main\\resources\\datasource\\datasource.properties";

    private static DataSource dataSource;
    private static DataSource setupDatasource(){
        BasicDataSource basicDataSource = new BasicDataSource();
        Properties properties = readConfig();
        if (!properties.isEmpty()) {
            basicDataSource.setUrl(properties.getProperty(DataSourceConstants.URL));
            basicDataSource.setDriverClassName(properties.getProperty(DataSourceConstants.DRIVER));
            basicDataSource.setUsername(properties.getProperty(DataSourceConstants.USERNAME));
            basicDataSource.setPassword(properties.getProperty(DataSourceConstants.PASSWORD));
            basicDataSource.setMaxIdle(Integer.parseInt(properties.getProperty(DataSourceConstants.MAX_IDLE)));
            basicDataSource.setMinIdle(Integer.parseInt(properties.getProperty(DataSourceConstants.MIN_IDLE)));
            basicDataSource.setMaxOpenPreparedStatements(Integer.parseInt(properties.getProperty(DataSourceConstants.MAX_OPEN_PREPARED_STATEMENTS)));
        }
        return basicDataSource;
    }

    public static DataSource getDatasource() {
        if (dataSource != null) {
            return dataSource;
        } else {
            dataSource = setupDatasource();
            return dataSource;
        }
    }

    private static Properties readConfig() {
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream(new File(System.getProperty("user.dir")).getAbsolutePath() + "\\" + new File(configPath))) {
            properties.load(inputStream);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
