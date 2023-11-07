package extentreports;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.BaseTest;

public class ExtentManager extends BaseTest {
	
	static String reportsFolderPath;
	public static ExtentReports getReports()
	{
		
		if(reports==null)
		{
			reports=new ExtentReports();
			 reportsFolderPath=System.getProperty("user.dir")+"\\reports";
			
			File reportsFolder=new File(reportsFolderPath);
			
			reportsFolder.mkdir();
			
			String pattern = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

			String date = simpleDateFormat.format(new Date());
			
			date=date.replace(":", "-");
			
			String filePath=reportsFolderPath+"\\"+date+".html";
			
			System.out.println(filePath);
			
			File reportFile=new File(filePath);
			
			ExtentSparkReporter reporter=new ExtentSparkReporter(reportFile);
			
			reporter.config().setDocumentTitle("Adactin QA Regression Reports");
			
			reports.attachReporter(reporter);
			
			
		}
		
		return reports;
		
	}

}
