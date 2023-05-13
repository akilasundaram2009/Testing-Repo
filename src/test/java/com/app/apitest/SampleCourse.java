package com.app.apitest;

import org.testng.annotations.Test;

import com.app.payload.BasePayloads;

import io.restassured.path.json.JsonPath;

public class SampleCourse {
	
	@Test
	public void test1() {
		JsonPath js = new JsonPath(BasePayloads.course());
		//Print No of courses returned by API
		int count = js.getInt("courses.size()");
		System.out.println(count);
		
		//Print Purchase Amount
		int totalamount = js.getInt("dashboard.purchaseAmount");
		System.out.println(totalamount);
		
		//Print Title of the first course
		String getfirst = js.get("courses[0].title");
		int price = js.getInt("courses[0].price");
		System.out.println(getfirst);
		System.out.println(price);
	
	
	//Print All course titles and their respective Prices
		for (int i = 0; i < count; i++) {
			String titles = js.get("courses["+i+"].title");
			String prices = js.getString("courses["+i+"].price");
			System.out.println(titles);
			System.out.println(prices);

	//Print no of copies sold by RPA Course
		for (int j = 0; j <count; j++) {
			String ct = js.get("courses["+i+"].title");	
			if(ct.equalsIgnoreCase("Cypress")) {
				int cop = js.get("courses["+i+"].copies");	
				System.out.println(cop);
			}
			
	//Verify if Sum of all Course prices matches with Purchase Amount
			
		for (int k = 0; k < count; k++) {
			int prices1 = js.getInt("courses["+k+"].price");	
			int copies = js.get("courses["+k+"].copies");
			int totalamount1 = js.getInt("dashboard.purchaseAmount");
			
			
			
		}	
				
		}	
			
			
		}
	
	}
}
