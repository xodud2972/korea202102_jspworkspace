package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class GsonTest {

	public static void main(String[] args) {
		Map<String, List> map = new HashMap<String, List>();
		Fruit f = new Fruit();
		f.name="사과";
		f.price=3000;
		
		Fruit f2 = new Fruit();
		f2.name="사과";
		f2.price=3000;
		
		ArrayList<Fruit> list = new ArrayList<Fruit>();
		list.add(f);
		list.add(f2);
		
		map.put("fruits", list);
		
		Gson gson= new Gson();
		String str = gson.toJson(map);
		
		System.out.println(str);

	}

}
