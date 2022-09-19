package Testcases;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
//import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import utilities.CommonExcelSheet;

public class PostUser {
  @Test
  public void f() throws BiffException, IOException {
//	  File f = new File("C:\\Users\\Suroju Venkatesh\\eclipse-workspace\\api\\src\\test\\java\\testdata.xls");
//	  Workbook wb = Workbook.getWorkbook(f);
//	  Sheet sheet = wb.getSheet(2);
	  CommonExcelSheet g = new CommonExcelSheet();
	  System.out.println("Creating new user");
	  Cell c1 = g.getsheet().getCell(1,0);
	  RestAssured.baseURI = c1.getContents();
	  Cell c2 = g.getsheet().getCell(1, 9);
	  String name = c2.getContents();
	  Cell c3 = g.getsheet().getCell(2, 9);
	  String job = c3.getContents();
	  Cell c4 = g.getsheet().getCell(6, 9);
	  String endpoint = c4.getContents();
	  String jsonString = "{\n"
	  		+ "    \"name\": \""+ name +"\",\n"
	  		+ "    \"job\": \""+ job + "\"\n"
	  		+ "}";
		RequestSpecification requestSpecification= RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.body(jsonString);
		Response response = requestSpecification.post(endpoint);
		String responsestring = response.asPrettyString();
		System.out.println(responsestring);
//		ValidatableResponse validatableResponse = response.then();
//		validatableResponse.statusCode(201);
//		Response response123 = RestAssured.get("https://reqres.in/api/users");
//		System.out.println(response123.getStatusLine());
//		validatableResponse.statusLine("HTTP/1.1 201 Created");
//	    Response response1 = RestAssured.get("https://reqres.in/api/users");
//	    System.out.println(response1.asPrettyString());
//	    RestAssured.given().body(jsonString).
//	    when().post().then().statusCode(201);
//	    String j = "{\n"
//	    		+ "    \"name\": \"morpheus\",\n"
//	    		+ "    \"job\": \"leader\"\n"}";
		if(response.getStatusCode() == 201)
		  {
			  g.writeexcel("testcases", 12, 7, "passed");
		  }
		  else
		  {
			  g.writeexcel("testcases", 12, 7, "failed");
		  }
  }
}
