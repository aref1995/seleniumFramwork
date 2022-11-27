package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	// method to take screenshot when the test case failed
	public static void capturescreenshot(WebDriver driver , String screenshotname) {
		
		Path dest = Paths.get("./Screenshots",screenshotname+".png");
		try {
			Files.createDirectories(dest.getParent());
			FileOutputStream out = new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} catch (IOException e) {
		System.out.println("Exeption while taking screenshot"+e.getMessage());
		}
	}
}
