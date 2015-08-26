package vivino.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

// XmlPropertyLoader for loading properties from xml property file.

public class XmlPropertyLoader {

	// Load property from src/main/resources/properties.xml file.

	public static String loadProperty(String propertyName) {
		Properties props = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					"src/main/resources/properties.xml");
			props.loadFromXML(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return props.getProperty(propertyName);
	}

}
