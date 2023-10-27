package oct27th;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis=new FileInputStream("D:\\006 LiveTech\\jars\\Book1.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet ws=wb.getSheet("Sheet3");
		
		// case 1: Modifying existing cell in a row
		//ws.getRow(1).getCell(1).setCellValue("New Live Tech");
		
		//case 2: creating a cell in existing row
		
		//ws.getRow(2).createCell(1).setCellValue(100);
		
		//case 3: creating a row and cell in it 
		
		ws.createRow(3).createCell(0).setCellValue("Pass");
		
		FileOutputStream fos=new FileOutputStream("D:\\006 LiveTech\\jars\\Book1.xlsx");
		
		wb.write(fos);
		
		wb.close();
		
		System.out.println("End of Program..");

	}

}
