package com.app.base;

import io.restassured.path.json.JsonPath;

public class BaseClass {
	
	public static JsonPath rawJson(String response) {
		JsonPath js = new JsonPath(response);
		return js;
}

}
