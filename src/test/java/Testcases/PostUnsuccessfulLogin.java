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

public class PostUnsuccessfulLogin {
  @Test
  public void f() throws BiffException, IOException {
//	  File f = new File("C:\\Users\\Suroju Venkatesh\\eclipse-workspace\\api\\src\\test\\java\\testdata.xls");
//	  Workbook wb = Workbook.getWorkbook(f);
//	  Sheet sheet = wb.getSheet(2);
	  CommonExcelSheet g = new CommonExcelSheet();
	  System.out.println("Invalid user login");
	  Cell c1 = g.getsheet().getCell(1,0);
	  RestAssured.baseURI = c1.getContents();
	  Cell c2 = g.getsheet().getCell(3, 16);
	  String email = c2.getContents();
	  Cell c3 = g.getsheet().getCell(6, 16);
	  String endpoint = c3.getContents();
	  String jsonstring = "{\n"
	  		+ "    \"email\": \""+ email +"\"\n"
	  		+ "}";
		RequestSpecification requestSpecification= RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.body(jsonstring);
		Response response = requestSpecification.post(endpoint);
		System.out.println(response.getStatusCode());
		System.out.println(response.asPrettyString());
		System.out.println("user login unsuccessful");
		if(response.getStatusCode() == 400)
		  {
			  g.writeexcel("testcases", 12, 14, "passed");
		  }
		  else
		  {
			  g.writeexcel("testcases", 12, 14, "failed");
		  }
	
  }
}
