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

public class PostUnameCorrectPswrdIncorrectLogin {
  @Test
  public void f() throws BiffException, IOException {
	  CommonExcelSheet g = new CommonExcelSheet();

	  Cell c1 = g.getsheet().getCell(1,0);
	  RestAssured.baseURI = c1.getContents();
	  Cell c2 = g.getsheet().getCell(3, 19);
	  String email = c2.getContents();
	  Cell c3 = g.getsheet().getCell(4, 19);
	  String password = c3.getContents();
	  Cell c4 = g.getsheet().getCell(6, 19);
	  String endpoint = c4.getContents();
	  String jsonstring = "{\n"
	  		+ "    \"email\": \""+ email + "\",\n"
	  		+ "    \"password\": \""+ password + "\"\n"
	  		+ "}";
		RequestSpecification requestSpecification= RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.body(jsonstring);
		Response response = requestSpecification.post(endpoint);
		System.out.println(response.getStatusCode());
//		System.out.println("user login successful");
		System.out.println(response.asPrettyString());
		if(response.getStatusCode() == 200)
		  {
			  g.writeexcel("testcases", 12, 17, "failed");
			  System.out.println("login successful");

		  }
		  else
		  {
			  g.writeexcel("testcases", 12, 17, "passed");
		  }
  }
}
