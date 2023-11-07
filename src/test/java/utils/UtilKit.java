package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseTest;

public class UtilKit extends BaseTest {
	
	static FileInputStream fis;
	public static HashMap<String,String> getTestData(String testcase)
	{
		
		try {
			 fis=new FileInputStream("src\\test\\resources\\testdata\\excels\\regression\\Adactin Master Test Data.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XSSFWorkbook wb=null;
		try {
			 wb=new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XSSFSheet ws=wb.getSheet("com.adactin");
		
		ArrayList<Row> testCaseRows=getTestCaseRows(ws,testcase);
		
		HashMap<String, String> testDataMap=new HashMap<String, String>();
		
		
		
		for(int i=1;i<=testCaseRows.size();i++)
		{
			int noOfCells=testCaseRows.get(0).getLastCellNum();
			
			System.out.println("noOfCells "+noOfCells);
			
			for(int j=1;j<noOfCells;j++)
			{
				testDataMap.put(testCaseRows.get(0).getCell(j).getStringCellValue(), testCaseRows.get(1).getCell(j).getStringCellValue());
			}
		}
		
		
		return testDataMap;
		
	}
	
	public static ArrayList<Row> getTestCaseRows(XSSFSheet ws,String testcase)
	{
		
		ArrayList<Row> allRows=new ArrayList<Row>();
		
		for(int i=0;i<=ws.getLastRowNum();i++)
		{
			if(ws.getRow(i)!=null)
			{
			allRows.add(ws.getRow(i));
			}
		}
		
		
		ArrayList<Row> testCaseRows=new ArrayList<Row>();
		
		for(int i=0;i<allRows.size();i++)
		{
			
			if(allRows.get(i).getCell(0).getStringCellValue().equalsIgnoreCase(testcase))
			{
				//testCaseRows.add(ws.getRow(i));
				testCaseRows.add(allRows.get(i));
			}
		}
		
		System.out.println("NO of testCaseRows "+testCaseRows.size());
		return testCaseRows;
		
	}
	
	public static String getScreenshot(String testcaseName) 
	{
		 String screenshotsFolderPath=System.getProperty("user.dir")+"\\screenshots";
			
			File screenshotFolder=new File(screenshotsFolderPath);
			
			screenshotFolder.mkdir();
			
			String pattern = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

			String date = simpleDateFormat.format(new Date());
			
			date=date.replace(":", "-");
			
			String filePath=screenshotFolder+"\\"+testcaseName+date+".png";
			
		   File srcFile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		   try {
			FileUtils.copyFile(srcFile, new File(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   return filePath;
		
	}

}
