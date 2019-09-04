package example1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapDemo {
	private Map<String, String> map;
	
	public MapDemo() {
		// TODO Auto-generated constructor stub
		super();
		//map=new HashMap<String, String>();
		map=new TreeMap();
	}
	
	public void createMap() {
		map.put("name", "Rahul");
		map.put("address", "India");
		map.put("phone number", "123456");
		map.put("name", "1232");//overwrites the previous one, cannot add duplicate values
	}
	
	public Set<String> getMapKeys(){
		return map.keySet();
	}
	
	public Collection getMapValues(){
		return map.values(); 
	}
	public static void main(String args[]) {
	
		MapDemo demo = new MapDemo();
		demo.createMap();
		Set<String> set=demo.getMapKeys();
		for(String s:set) {
			System.out.println(s);
		}
//		Map str=demo.getMapValues();
//		System.out.println(str);
		Collection<String> str=demo.getMapValues();
		for(String s:str) {
			System.out.println(s);
		}
		Object[] s=str.toArray();
	}

}
