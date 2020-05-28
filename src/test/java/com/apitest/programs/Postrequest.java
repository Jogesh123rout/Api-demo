package com.apitest.programs;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Postrequest {
	@Test
public void postrequest() {
	// Set url
	RestAssured.baseURI="http://restapi.demoqa.com/customer";
	//request object
	RequestSpecification httprequest=RestAssured.given();
	//Request payload sending with post request
	JSONObject  request=new JSONObject();
	request.put("Firstname", "johnXYZ");
	request.put("LastName", "XYZJohn");
	request.put("Username", "JohnXyz");
	request.put("Password", "JohnXYZxyx");
    request.put("Email","JohnXYZ@gmail.com");
   httprequest.header("Content-Type","application/json");
httprequest.body(request.toJSONString());//attach this json 
//response object
Response response=httprequest.request(Method.POST,"/register");
//resonse body
String responsebody=response.getBody().asString();
System.out.println("Resonse body is:"+responsebody);
//status code
int statuscode=response.statusCode();
System.out.println("Status code is:"+statuscode);
Assert.assertEquals(statuscode,400 );
//sucess code validation
String sucessvalidation=response.jsonPath().get("SucessCode");
//Assert.assertEquals(sucessvalidation, "OPERATION_SUCCESS");
}
}
