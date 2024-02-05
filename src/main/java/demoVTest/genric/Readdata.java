package demoVTest.genric;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Readdata {
public String readpropertydata(String key) throws IOException {
	FileInputStream fis = new FileInputStream("./src/main/resources/loginDetails.properties.txt");
	Properties properties = new Properties();
	properties.load(fis);
	String data = properties.getProperty(key);
	return data;
}

}
