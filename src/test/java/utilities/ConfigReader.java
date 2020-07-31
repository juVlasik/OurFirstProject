package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties p;

	static {  //why static?

		p = new Properties();

		final String path = "config.properties"; //our key-value file

		try {
			FileInputStream fis = new FileInputStream(path);
			p.load(fis);
			fis.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	public static String getProperty(String key) {   
		
		return p.getProperty(key);
	}
}
