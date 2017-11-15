package app.utils.config;

import app.utils.FileManager;
import app.utils.ProjectConstants;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Properties;

/**
 * Created by Evgeny_Akulenko on 11/14/2017.
 */
@Component
public class ProjectConfiguration {

	private Properties configuration;

	@PostConstruct
	public void setupConfiguration() {
		configuration = FileManager.readFileAsProperties(ProjectConstants.MAIN_CONFIG_PATH);
	}

	public Properties getConfiguration() {
		return this.configuration;
	}

	public void updateConfig(String propertyName, String propertyValue) {
		configuration.put(propertyName, propertyValue);
		FileManager.saveFileAsProperties(ProjectConstants.MAIN_CONFIG_PATH, configuration);
	}
}
