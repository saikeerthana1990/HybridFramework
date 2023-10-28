package oct28th;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapDemo1 {

	public static void main(String[] args) {
		
		Map<String, Integer> hMap=new HashMap<String, Integer>();
		
		hMap.put("John", 89);
		
		hMap.put("David", 79);
		
		hMap.put("Sam", 80);
		
		hMap.put("Alex", 90);
		
		
		System.out.println(hMap.get("Sam"));
		
		System.out.println(hMap);
		
		Set<Entry<String, Integer>>  entries=hMap.entrySet();
		
		//using for each loop
		
		for(Entry<String, Integer> entry:entries)
		{
			System.out.println(entry.getKey()+"----"+entry.getValue());
		}
		
		
		
		

	}

}
