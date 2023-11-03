package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilKit {
	
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
		
		System.out.println("no of testCaseRows ..."+testCaseRows.size());
		System.out.println(testCaseRows);
		
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
		
		System.out.println("allRows Size "+allRows.size());
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

}
