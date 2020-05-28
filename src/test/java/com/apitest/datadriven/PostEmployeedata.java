package com.apitest.datadriven;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostEmployeedata {
	@Test(dataProvider="empdetails")
public void postempdata(String ename,String ejob) {
	RestAssured.baseURI="https://reqres.in/";
	RequestSpecification httprequest=RestAssured.given();
	JSONObject requestparams=new JSONObject();
	requestparams .put("name", ename);
	requestparams.put("job", ejob);
    httprequest.header("content-type","application/json");
	Response response=httprequest.request(Method.POST,"/api/users");
	String responsebody=response.getBody().asString();
	System.out.println(responsebody);
	//Assert.assertEquals(responsebody.contains(ename),true);
	//Assert.assertEquals(responsebody.contains(ejob),true);
	int statuscode=response.getStatusCode();
	System.out.println(statuscode);
	
}
	@DataProvider(name="empdetails")
	String  [][] getempdata(){
		String empdata[][]= {{"babuni","tester"},{"ranjan","develpoer"},{"Jogesh","clerck"}};
		
		return empdata;
	}
}
