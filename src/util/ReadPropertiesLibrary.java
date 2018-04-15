package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesLibrary {
	private Properties properties = null;

	public ReadPropertiesLibrary() {
		properties = new Properties();
	}

	public Properties readProperties() {
		String urlFile = getClass().getResource("").getPath();
		urlFile = urlFile.replaceFirst("/", "");
		urlFile = urlFile.replaceFirst("/classes/util/", "");
		System.out.println(urlFile);
		try {
			properties.load(new FileInputStream(""));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return properties;
	}
}
