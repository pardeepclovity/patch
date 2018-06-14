package patch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class devices {

	
WebDriver kenzen = kenzenpatch.kenzen;
	
	@Test(dataProvider= "getDataExcel" )
	
	public void delete(String name, String admin,String email )
	
	{
		int i =0;
		do 
		{
		kenzen.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		kenzen.findElement(By.id("devices")).click();
		kenzen.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[2]/div/button")).click();
		kenzen.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[4]/div/div[1]/div/section/div[2]/div[2]/input")).sendKeys(email);
		kenzen.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[4]/div/div[1]/div/section/div[2]/div[5]/button")).click();
		Select team = new Select(kenzen.findElement(By.id("select2")));
		team.selectByIndex(i);
		i++;
		}while (i<=7);
		
		
		/*Random random = new Random();
		int index = random.nextInt(5);  // It will give a range between 0 to 4
		System.out.println("Index is "+index);
		List<WebElement> list = kenzen.findElements(By.tagName("a"));
		System.out.println("Number of links: " + list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());*/
		
		
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
