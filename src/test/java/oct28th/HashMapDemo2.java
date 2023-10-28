package oct28th;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapDemo2 {

	public static void main(String[] args) {
		
		Map<String, Integer> hMap=new HashMap<String, Integer>();
		
		hMap.put("John", 89);
		
		hMap.put("David", 79);
		
		hMap.put("Sam", 80);
		
		hMap.put("Alex", 90);
		
		
		System.out.println(hMap.get("Sam"));
		
		System.out.println(hMap);
		
		Set<Entry<String, Integer>>  entries=hMap.entrySet();
		
		//using  iterator
		
		
		Iterator<Entry<String, Integer>> it=entries.iterator();
		
		Entry<String, Integer> entry=null;
		
		while(it.hasNext())
		{
			entry=it.next();
			
			System.out.println(entry.getKey()+"----"+entry.getValue());
		}
		
		
		

	}

}
