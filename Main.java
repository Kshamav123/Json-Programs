package com.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class Main {

	public static void main(String[] args) throws ParseException {

		JSONParser jsonParser = new JSONParser();
		// /Users/kshamavidyananda/eclipse-workspace/JsonPrograms/Data/inventory.json
		Map<String, Double> map = new HashMap<>();
		try {
			Reader reader = new FileReader(
					"/Users/kshamavidyananda/eclipse-workspace/JsonPrograms/Data/inventory.json");
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
//			System.out.println(jsonObject);
			JSONArray array = (JSONArray) jsonObject.get("inventory");
//            System.out.println(array);
			//jsonParser.parse(reader);
            Iterator<JSONObject> iterator = array.iterator();
            while (iterator.hasNext()) {
            	JSONObject jsonobject1 = (JSONObject) iterator.next();
            	System.out.println(jsonobject1);
            	String name = (String) jsonobject1.get("name");
				System.out.println(name);
				double price = (double) jsonobject1.get("pricePerKg");
				double weight = (double) jsonobject1.get("weight");
				System.out.println("Name: " + name + " price: " + price + " Weight: " + weight);
				map.put(name, price * weight);
			}
            
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ParseException e) {

			e.printStackTrace();
		}
		writeJSon(map);
	}

	private static void writeJSon(Map<String, Double> map) {
		JSONArray array = new JSONArray();
		
		for (Entry<String, Double> entry : map.entrySet()) {
			JSONObject object = new JSONObject();
			object.put("name", entry.getKey());
			object.put("totalPrice", entry.getValue());
			
			array.add(object);
		}
		JSONObject mainObject = new JSONObject();
		mainObject.put("results", array);
		try {
			FileWriter writer = new FileWriter("/Users/kshamavidyananda/eclipse-workspace/JsonPrograms/Data/results.json");
			writer.write(mainObject.toJSONString());
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(mainObject);
		System.out.println(map);
		
		
	}
}
