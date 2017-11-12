package datasource;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Gaidin on 12.11.2017.
 */
public class DataSourceManager {
    private static String configPath = "src\\main\\resources\\datasource\\datasource.properties";

    private DataSource dataSource;
    private void setupDatasource(DataSource dataSource){
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
    }

    public DataSource getDatasource() {
        if (dataSource != null) {
            return dataSource;
        } else {
            setupDatasource(dataSource);
            return dataSource;
        }

    }

    private Properties readConfig() {

        Properties properties = new Properties();
        System.out.println(new File(System.getProperty("user.dir")).getAbsolutePath() + "\\" + new File(configPath));
        try (FileInputStream inputStream = new FileInputStream(new File(System.getProperty("user.dir")).getAbsolutePath() + "\\" + new File(configPath))) {
            properties.load(inputStream);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static void main(String[] args) {
        DataSourceManager manager = new DataSourceManager();
        DataSource dataSource = manager.getDatasource();
    }
}
