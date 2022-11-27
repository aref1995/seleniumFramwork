package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDataReader {

	public String Fname,Lname,email,pass;
	
	public void Jsonreader() throws FileNotFoundException, IOException, ParseException {
		
		String filepath="C:\\Users\\aaref\\eclipse-workspace\\TAF\\src\\test\\java\\data\\UserData.JSON";
		File srcfile = new File(filepath);
		
		JSONParser parser = new JSONParser();
		JSONArray jarray = (JSONArray)parser.parse(new FileReader(srcfile)); 
		 
		for (Object Jsonobj : jarray) {
			
			JSONObject persone = (JSONObject) Jsonobj;
			Fname = (String) persone.get("firstname");
			Lname = (String)persone.get("lastname");
			email = (String)persone.get("email");
			pass = (String)persone.get("pass");
		}
		
	}
}
