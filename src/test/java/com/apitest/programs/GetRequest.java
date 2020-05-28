package com.apitest.programs;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {
	@Test
	public void getWeather() {
//Specify the base url
	RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
	//create request object
	RequestSpecification httprequest=RestAssured.given();
	//Response object
	Response response=httprequest.request(Method.GET,"/hyderabad");
	//print response
	String responsebody=response.getBody().asString();
	System.out.println("Response body:"+responsebody);
	//Status code validation
	int responsecode=response.getStatusCode();
	System.out.println("Response cose is:"+responsecode);
	Assert.assertEquals(responsecode, 200);
	//status line validation
	String statusline=response.statusLine();
	System.out.println("Status line is:"+statusline);
	Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
	}
}
