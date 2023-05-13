package com.app.apitest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TestOne {

	public static void main(String[] args) {
	
	try {
		FileReader read = new FileReader("C:\\Eclipse workspace\\ApiSample\\src\\test\\resources\\TestData\\sample.json");
		JSONParser jsobj = new JSONParser();
		try {
			Object obj = jsobj.parse(read);
			JSONObject jo = (JSONObject)obj;
			String name = (String) jo.get("name");
			System.out.println(name);
			String age = (String) jo.get("age");
			System.out.println(age);
			
			JSONArray jarr = (JSONArray)jo.get("bike");
			System.out.println(jarr.get(2));
			
			JSONArray jarr1 = (JSONArray)jo.get("course");
						
			for (Object object : jarr1) {
		
				System.out.println(object);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
	} catch (FileNotFoundException e) {
				e.printStackTrace();
	}
		
	
	}

}
