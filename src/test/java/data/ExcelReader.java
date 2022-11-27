package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static FileInputStream fis= null ;

	public FileInputStream getfileinputstream() {

		String filepath= (System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserData.xlsx");
		File scrfiFile = new File(filepath);
		try {
			fis = new FileInputStream(scrfiFile);
		} catch (FileNotFoundException e) {
			System.out.println("Test Data File Not Found:"+e.getMessage());
		}
		return fis;
	}

	public Object [][] getexceldata() throws IOException{

		fis = getfileinputstream();
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);

		int Totalnumofrow=(sheet.getLastRowNum()+1);
		int Totalnumofclo=4;

		String [][] aarayexceldata = new String[Totalnumofrow][Totalnumofclo];

		for (int i = 0; i < Totalnumofrow; i++) {
			for (int j = 0; j < Totalnumofclo; j++) {
				XSSFRow row = sheet.getRow(i);
				aarayexceldata[i][j]=row.getCell(j).toString();

			}
		}
		wb.close();
		return aarayexceldata;
	}
}
