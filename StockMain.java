package com.json;import java.io.FileNotFoundException;
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
public class StockMain {
	
	public static void main(String[] args) {
		Map<String, Double> map = new HashMap<>();
		JSONParser jsonParser = new JSONParser();
		try {
			Reader reader = new FileReader("/Users/kshamavidyananda/eclipse-workspace/JsonPrograms/Data/stock.json");
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			//System.out.println(jsonObject);
			JSONArray array = (JSONArray) jsonObject.get("stock");
			System.out.println();
			System.out.println(array);
			Iterator<JSONObject> iterator = array.iterator();
			while (iterator.hasNext()) {
				JSONObject jsonObject1 = (JSONObject) iterator.next();
				//System.out.println(jsonObject1);
				String name = (String) jsonObject1.get("name");
				double noOfShares = (double) jsonObject1.get("noOfShares");
				double price = (double) jsonObject1.get("sharePrice");
				System.out.println("Name: " + name + " No of shares: " + noOfShares + " Price: " + price);
				System.out.println();
				map.put(name, price * noOfShares);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		writeJson(map);

	}
	

	private static void writeJson(final Map<String, Double> map) {
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
			FileWriter writer = new FileWriter("/Users/kshamavidyananda/eclipse-workspace/JsonPrograms/Data/stockresults.json");
			writer.write(mainObject.toJSONString());
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(mainObject);
		System.out.println(map);
	}
}
	


