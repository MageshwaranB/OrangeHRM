package datadrivern;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utils.Excel_Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenTest
{
	public static WebDriver driver;
	public static Excel_Utility excelReader;
	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		String filepath="./src/test/resources/TestData.xlsx";
		
		excelReader=new Excel_Utility(filepath);
		
		int rowCount=excelReader.getRowCount("Data");
		
		System.out.println(rowCount);
		int colCount=excelReader.getColumnCount("Data");
		System.out.println(colCount);
		/*for (int i = 0; i <= rowCount; i++) {
		
			{
				for (int j = 0; j <=colCount; j++)
				{
					System.out.println(excelReader.getCellData("Data", j, i));
				}
			}
		}
		*/
		/*System.out.println(excelReader.getCellData("Data", 1, 1));
		System.out.println(excelReader.getCellData("Data", 0, 2));
		System.out.println(excelReader.getCellData("Data", 1, 2));
		System.out.println(excelReader.getCellData("Data", 0, 3));
		System.out.println(excelReader.getCellData("Data", 1, 3));
		*/
		for (int row = 2;  row<=rowCount; row++)
		{
			driver=new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/");
			String username=excelReader.getCellData("Data", "username", row);
			driver.findElement(By.id("txtUsername")).sendKeys(username);
			System.out.println(username);
			
			String password=excelReader.getCellData("Data", "password", row);
			driver.findElement(By.id("txtPassword")).sendKeys(password);
			System.out.println(password);
			driver.findElement(By.id("btnLogin")).click();
			driver.close();
		}
	}
}
