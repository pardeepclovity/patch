package patch;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class deleteTeam {
	
	WebDriver kenzen = kenzenpatch.kenzen;
	
	@Test(dataProvider= "getDataExcel" )
	
	public void delete(String name, String admin,String email )
	
	{
		
		kenzen.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		kenzen.findElement(By.id("teamsummary")).click();
		kenzen.findElement(By.linkText(name)).click();
		kenzen.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div/div[6]/div/a")).click();
		kenzen.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/section/div[2]/div[5]/button[1]")).click();
	
			
			
	}

	@AfterTest
	
	public void closedriver()
	{
		kenzen.quit();
	}
	
	
	/*@DataProvider
	public String[][] getDataExcel() throws InvalidFormatException, IOException{
	ReadExcel read = new ReadExcel();
	return read.getCellData("E:\\Learning\\addteam.xls", "addteam1");
	}
	*/
	
	
	
	@DataProvider(name="getDataExcel")
	public Object[][] ExcelData()
	{
		Object[][] Data = getExcelData("E:\\Learning\\addteam.xls","addteam1");
		return Data;
	}
	private Object[][] getExcelData(String addteam, String addteam1)
	 {
		
		String[][] ExcelData = null;
		try{
			
			FileInputStream fs = new FileInputStream(addteam);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet(addteam1);
			int totalNoOfRows = sh.getRows();
			int totalNoOfCols = sh.getColumns();
			
			
			ExcelData = new String[totalNoOfRows-1][totalNoOfCols];
			
			for(int i=1;i<totalNoOfRows;i++)
			{
				for(int j=0;j<totalNoOfCols;j++)
				{
					ExcelData[i-1][j] = sh.getCell(j, i).getContents();
				}
			}
			
			
		} catch(FileNotFoundException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		} catch(BiffException e){
			e.printStackTrace();
		}
		return ExcelData;
		
		
	}
}
