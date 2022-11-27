package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {

	//Load properties file from folder 
	
	public static Properties userdata= loadProperties
			(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\userdata.properties");
	
	
	private static Properties loadProperties(String path) {
		
		Properties pro = new Properties();
		//stream for reading file 
		try {
			FileInputStream stream = new FileInputStream(path);
			pro.load(stream);
		} catch (FileNotFoundException e) {
		System.out.println("Error accurred :"+ e.getMessage());
		} catch (IOException e) {
			System.out.println("Error accurred :"+ e.getMessage());
		}
		return pro;
	}
}
