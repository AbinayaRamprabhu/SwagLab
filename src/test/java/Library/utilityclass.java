package Library;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

public class utilityclass  extends baseclass
{
	public static String readPFData(String key) throws IOException 
	{
	FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"//TesData//config.properties");
	Properties prop=new Properties();
	prop.load(file);
	String value=prop.getProperty(key);
	return value;
	}
	public static void captureSS(int TCID) throws IOException
	{
		File dest=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File src=new File(System.getProperty("user.dir")+"//FailedtestcasesScreenShots//FailedTestCase_"+TCID+".jpg");
		FileHandler.copy(dest, src);
	}
	 public static int generateRandomNumber(int lowerBound, int upperBound) {
	        	        Random random = new Random();

	       	        int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

	        return randomNumber;
	    }
	 public static float removeFirstLetterAndReturnFloat(String string) {
	        if (string == null || string.isEmpty()) {
	            return Float.NaN;
	        }
	        try {
	            return Float.parseFloat(string.substring(1));
	        } catch (NumberFormatException e) {
	            return Float.NaN;
	        }
	    }
	 public static String getExcelData(int RowNum, int ColNum, String SheetName) {
	        XSSFWorkbook workBook;
	        XSSFSheet sheet;
	        String projectPath = System.getProperty("user.dir");
	        String cellData = null;
	        try {
	            workBook = new XSSFWorkbook(projectPath + "/project1/TestData/TestData.xls");
	            sheet = workBook.getSheet(SheetName);
	            cellData = sheet.getRow(RowNum).getCell(ColNum).getStringCellValue();

	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	            System.out.println(e.getCause());
	            e.printStackTrace();
	        }
	        return cellData;
	    }
}

