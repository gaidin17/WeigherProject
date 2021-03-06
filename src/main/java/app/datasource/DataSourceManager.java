package app.datasource;

import app.utils.FileManager;
import app.utils.ProjectConstants;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Gaidin on 12.11.2017.
 */
@Component
public class DataSourceManager {

    private DataSource dataSource;

    private DataSource setupDatasource(){
        BasicDataSource basicDataSource = new BasicDataSource();
        Properties properties = FileManager.readFileAsProperties(ProjectConstants.DATASOURCE_CONFIG_PATH);
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

    public DataSource getDatasource() {
        if (dataSource != null) {
            return dataSource;
        } else {
            dataSource = setupDatasource();
            return dataSource;
        }
    }

}
