package app.utils.config;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Evgeny_Akulenko on 11/14/2017.
 */
@Component
public class PropertyManager {

	public void saveConfig(String path, String propertyName, String propertyValue) {

	}

	public Properties readConfig(String path) {
		Properties properties = new Properties();
		try (FileInputStream inputStream =
				new FileInputStream(new File(System.getProperty("user.dir")).getAbsolutePath() + "\\" + new File(path))) {
			properties.load(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
}
