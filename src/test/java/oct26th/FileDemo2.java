package oct26th;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileDemo2 {

	public static void main(String[] args) throws IOException {
		
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String date=simpleDateFormat.format(new Date());
		
		date=date.replace(":", "-");
		
		File f=new File("D:\\006 LiveTech\\jars\\"+"abc"+date+".txt");
		
		 System.out.println(f.createNewFile());
		
		System.out.println("End of Program..");
		
	}

}
