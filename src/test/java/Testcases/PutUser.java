package Testcases;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import utilities.CommonExcelSheet;

public class PutUser {
  @Test
  public void f() throws BiffException, IOException {
//	  File f = new File("C:\\Users\\Suroju Venkatesh\\eclipse-workspace\\api\\src\\test\\java\\testdata.xls");
//	  Workbook wb = Workbook.getWorkbook(f);
//	  Sheet sheet = wb.getSheet(2);
	  CommonExcelSheet g = new CommonExcelSheet();
	  System.out.println("Updating user details");
	  Cell c1 = g.getsheet().getCell(1,0);
	  RestAssured.baseURI = c1.getContents();
	  Cell c2 = g.getsheet().getCell(1, 10);
	  String name = c2.getContents();
	  Cell c3 = g.getsheet().getCell(2, 10);
	  String job = c3.getContents();
	  Cell c4 = g.getsheet().getCell(2, 10);
	  String id = c4.getContents();
	  Cell c5 = g.getsheet().getCell(6, 10);
	  String endpoint = c5.getContents();
		String jsonString = "{\n"
				+ "    \"name\": \""+ name + "\",\n"
				+ "    \"job\": \""+ job + "\"\n"
				+ "}";
		RequestSpecification requestspecification = RestAssured.given();
		requestspecification.body(jsonString);
		Response response = requestspecification.put(endpoint + id);
			System.out.println("Put Updation successful");
			System.out.println(response.getStatusCode());
			System.out.println(response.asPrettyString());
			if(response.getStatusCode() == 200)
			  {
				  g.writeexcel("testcases", 12, 8, "passed");
			  }
			  else
			  {
				  g.writeexcel("testcases", 12, 8, "failed");
			  }
  }
}
