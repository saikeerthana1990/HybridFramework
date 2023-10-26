package oct26th;

import java.io.File;
import java.io.IOException;

public class FileDemo1 {

	public static void main(String[] args) throws IOException {
		
		File f=new File("D:\\006 LiveTech\\jars\\abc.txt");
		
		 System.out.println(f.createNewFile());
		
		System.out.println("End of Program..");
		
	}

}
