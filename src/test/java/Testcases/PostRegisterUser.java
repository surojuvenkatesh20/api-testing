package Testcases;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import utilities.CommonExcelSheet;

public class PostRegisterUser {
  @Test
  public void f() throws BiffException, IOException {
//	  File f = new File("C:\\Users\\Suroju Venkatesh\\eclipse-workspace\\api\\src\\test\\java\\testdata.xls");
//	  Workbook wb = Workbook.getWorkbook(f);
//	  Sheet sheet = wb.getSheet(2);	  
	  CommonExcelSheet g = new CommonExcelSheet();
	  Cell c1 = g.getsheet().getCell(1,0);
	  RestAssured.baseURI = c1.getContents();
	  Cell c2 = g.getsheet().getCell(3, 13);
	  String email = c2.getContents();
	  Cell c3 = g.getsheet().getCell(4, 13);
	  String password = c3.getContents();
	  Cell c4 = g.getsheet().getCell(6, 13);
	  String endpoint = c4.getContents();
	  String jsonstring = "{\n"
	  		+ "    \"email\": \"" + email + "\",\n"
	  		+ "    \"password\": \"" + password + "\"\n"
	  		+ "}";
		RequestSpecification requestSpecification= RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.body(jsonstring);
		Response response = requestSpecification.post(endpoint);
		System.out.println("user registered");
		System.out.println(response.getStatusCode());
		System.out.println(response.asPrettyString());
		System.out.println();
		if(response.getStatusCode() == 200)
		  {
			  g.writeexcel("testcases", 12, 11, "passed");
		  }
		  else
		  {
			  g.writeexcel("testcases", 12, 11, "failed");
		  }
  }
}
