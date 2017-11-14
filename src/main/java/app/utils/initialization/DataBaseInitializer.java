package app.utils.initialization;

import app.datasource.DataSourceManager;
import app.utils.FileManager;
import app.utils.ProjectConstants;
import app.utils.config.ProjectConfiguration;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Evgeny_Akulenko on 11/13/2017.
 */
@Component
public class DataBaseInitializer extends Initializer {

	@Autowired
	private DataSourceManager dataSourceManager;

	@Autowired
	private ProjectConfiguration configuration;

	@Override
	public void initialize() {
		DataSource dataSource = dataSourceManager.getDatasource();
		if (!isDatabaseInitialized()) {
			try (Connection connection = dataSource.getConnection(); Statement statement = connection.createStatement()) {
				statement.execute(FileManager.readFileAsString(ProjectConstants.DEFINITION_SQL_SCRIPTS_PATH));
				saveInitStausToConfiguration();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} else {
			System.out.println("db was initialized");
		}
	}

	private boolean isDatabaseInitialized() {
		return BooleanUtils.toBoolean(configuration.getConfiguration().getProperty(ProjectConstants.DATABASE_INITIALIZED_PROPERTY_NAME));
	}

	private void saveInitStausToConfiguration() {
		configuration.updateConfig(ProjectConstants.DATABASE_INITIALIZED_PROPERTY_NAME, Boolean.TRUE.toString());
	}
}
