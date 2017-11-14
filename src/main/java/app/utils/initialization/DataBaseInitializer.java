package app.utils.initialization;

import app.datasource.DataSourceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

/**
 * Created by Evgeny_Akulenko on 11/13/2017.
 */
@Component
public class DataBaseInitializer extends Initializer {
	private static String definitionScriptPath = "src\\main\\resources\\sqlScripts\\createTables.sql";
	@Autowired
	private DataSourceManager dataSourceManager;

	@Override
	public void initialize() {
		DataSource dataSource = dataSourceManager.getDatasource();
		try (Connection connection = dataSource.getConnection(); Statement statement = connection.createStatement()) {
			statement.execute(readDefinitionScript());
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	private static String readDefinitionScript() {
		String queryString = "";
		try (FileInputStream inputStream = new FileInputStream(
				new File(System.getProperty("user.dir")).getAbsolutePath() + "\\" + new File(definitionScriptPath));
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
			String fileString;
			StringBuilder builder = new StringBuilder();
			while ((fileString = reader.readLine()) != null) {
				builder.append(fileString);
			}
			queryString = builder.toString();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return queryString;
	}

}
