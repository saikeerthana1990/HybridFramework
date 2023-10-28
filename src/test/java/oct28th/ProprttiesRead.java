package oct28th;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ProprttiesRead {

	public static void main(String[] args) throws IOException {
		
		
		FileInputStream fis=new FileInputStream("Properties\\config.properties");
		
		Properties pr=new Properties();
		
		pr.load(fis);
		
		System.out.println(pr.getProperty("browser"));
		
		
		
		

	}

}
