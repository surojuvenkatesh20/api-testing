package Testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jxl.Cell;
import jxl.read.biff.BiffException;
import utilities.CommonExcelSheet;

public class PatchUpdateUserName {
  @Test
  public void f() throws BiffException, IOException {
	  CommonExcelSheet g = new CommonExcelSheet();
	  System.out.println("Updating user details");
	  Cell c1 = g.getsheet().getCell(1,0);
	  RestAssured.baseURI = c1.getContents();
	  Cell c2 = g.getsheet().getCell(1, 24);
	  String name = c2.getContents();
	  Cell c4 = g.getsheet().getCell(5, 24);
	  String id = c4.getContents();
	  Cell c5 = g.getsheet().getCell(6, 24);
	  String endpoint = c5.getContents();
		String jsonString = "{\n"
				+ "    \"name\": \""+ name + "\",\n"
				+ "}";
		RequestSpecification requestspecification = RestAssured.given();
		requestspecification.body(jsonString);
		Response response = requestspecification.patch(endpoint + id);
			System.out.println("Patch Updation successful");
			System.out.println(response.getStatusCode());
			System.out.println(response.asPrettyString());
			if(response.getStatusCode() == 200)
			  {
				  g.writeexcel("testcases", 12, 22, "passed");
			  }
			  else
			  {
				  g.writeexcel("testcases", 12, 22, "failed");
			  }
  }
}
