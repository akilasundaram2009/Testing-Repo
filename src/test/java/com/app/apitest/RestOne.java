package com.app.apitest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;

import com.app.payload.BasePayloads;

import static io.restassured.RestAssured.*;

public class RestOne {

	public static void main(String[] args) {
		RestAssured.baseURI="https://rahulshettyacademy.com";
	String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(BasePayloads.addplace())
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200)
		.body("scope", equalTo("APP"))
		.extract().response().asString();
		System.out.println(response);
		JsonPath js = new JsonPath (response);
		String placeid = js.getString("place_id");
		System.out.println(placeid);
		
		//put method
		
		String data = "71 winter walk, USA";
		given().log().all().queryParam("place_id", placeid).queryParam("key", "qaclick123").header("Content-Type", "application/json")
	.body("{\r\n" + 
			"\"place_id\":\""+placeid+"\",\r\n" + 
			"\"address\":\""+data+"\",\r\n" + 
			"\"key\":\"qaclick123\"\r\n" + 
			"}")	
	.when().put("/maps/api/place/add/json")
	.then().log().all().assertThat().statusCode(200);
	
	//get method
	String rep = given().log().all().queryParam("place_id", placeid).queryParam("key", "qaclick123").header("Content-Type", "application/json")
	.queryParam("key", "qaclick123")
	.when().get("/maps/api/place/add/json")
	.then().assertThat().log().all().statusCode(200).extract().response().asString();
	System.out.println(rep);
	
	}

}
