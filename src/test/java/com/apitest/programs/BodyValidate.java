package com.apitest.programs;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BodyValidate {
	@Test
public void checkresponsebody() {
	RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
	RequestSpecification httprequest=RestAssured.given();
	Response response=httprequest.request(Method.GET,"/Mumbai");
String responsebody=response.getBody().asString();
System.out.println("Response body is:"+responsebody);
Assert.assertEquals(responsebody.contains("Mumbai"), true);
}
}
