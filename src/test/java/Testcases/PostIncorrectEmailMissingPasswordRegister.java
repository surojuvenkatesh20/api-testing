package Testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jxl.Cell;
import jxl.read.biff.BiffException;
import utilities.CommonExcelSheet;

public class PostIncorrectEmailMissingPasswordRegister {
  @Test
  public void f() throws BiffException, IOException {
	  CommonExcelSheet g = new CommonExcelSheet();
	  System.out.println("Invalid user registration");
	  Cell c1 = g.getsheet().getCell(1,0);
	  RestAssured.baseURI = c1.getContents();
	  Cell c2 = g.getsheet().getCell(3, 23);
	  String email = c2.getContents();
	  Cell c3 = g.getsheet().getCell(6, 23);
	  String endpoint = c3.getContents();
	  String jsonstring = "{\n"
	  		+ "    \"email\": \"" + email + "\"\n"
	  		+ "}";
	    RequestSpecification requestSpecification= RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.body(jsonstring);
		Response response = requestSpecification.post(endpoint);
		System.out.println(response.getStatusCode());
		System.out.println(response.asPrettyString());
		System.out.println("user not registered");
		if(response.getStatusCode() == 404)
		  {
			  g.writeexcel("testcases", 12, 21, "passed");
			  System.out.println("failed");
		  }
		  else
		  {
			  g.writeexcel("testcases", 12, 21, "failed");
//			  System.out.println("passssed");
		  }
  }
}
