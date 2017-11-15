package app.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by Evgeny_Akulenko on 11/14/2017.
 */

public class FileManager {

	public static void saveFileAsProperties(String path, Properties properties) {
		try (FileOutputStream fileOutputStream = new FileOutputStream(ProjectConstants.MAIN_CONFIG_PATH);) {
			properties.store(fileOutputStream, "");
		} catch (FileNotFoundException ex) {
			System.out.println("main config file was not found");
		} catch (IOException ex) {

		}
	}

	public static Properties readFileAsProperties(String path) {
		Properties properties = new Properties();
		try (FileInputStream inputStream =
				new FileInputStream(new File(path))) {
			properties.load(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

	public static String readFileAsString(String path) {
		String queryString = "";
		try (FileInputStream inputStream = new FileInputStream(
				new File(path));
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
