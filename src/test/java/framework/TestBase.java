package framework;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
public static RequestSpecification httprequest;
public static Response response;
public  Logger logger;
public void setup() {
	logger=logger.getLogger(TestBase.class);
	PropertyConfigurator.configure("Log4j.properties");
	logger.setLevel(Level.DEBUG);
}
}
