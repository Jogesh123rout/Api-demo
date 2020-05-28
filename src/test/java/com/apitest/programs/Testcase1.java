package com.apitest.programs;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import framework.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class Testcase1  extends TestBase {
@BeforeClass
	void Getlistuser() {
 
	RestAssured.baseURI="https://reqres.in/";
	httprequest=RestAssured.given();
	response=httprequest.request(Method.GET,"/api/users/2");
	
}
@Test
void Checkbody() {
	logger.info("*******************Checking response body**********************");
	String responsebody=response.getBody().asString();
	Assert.assertTrue(responsebody!=null);
}
@Test
void statuscode() {
	logger.info("***********************Checking status code**********************");
	int statuscode=response.getStatusCode();
	Assert.assertEquals(statuscode, 200);
}
@Test
void responsetime() {
	logger.info("*************************checking response time*********************");
	long responsetime=response.getTime();
	logger.info("Response time is"+responsetime);
}
@AfterClass
void teardown() {
	logger.info("*********************Close all test case*************************");
	
}
}
