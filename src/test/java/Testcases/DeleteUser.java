package Testcases;
import utilities.CommonExcelSheet;
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

public class DeleteUser {
  @Test
  public void f() throws BiffException, IOException {
	  CommonExcelSheet c = new CommonExcelSheet();
//	    File f = new File("C:\\Users\\Suroju Venkatesh\\eclipse-workspace\\api\\src\\test\\java\\testdata.xls");
//		Workbook wb = Workbook.getWorkbook(f);
//		Sheet sheet = wb.getSheet(2);
		Cell c1 = c.getsheet().getCell(1, 0);
		RestAssured.baseURI = c1.getContents();
		Cell c2 = c.getsheet().getCell(5, 12);
		String id = c2.getContents();
		Cell c3 = c.getsheet().getCell(6, 12);
		String endpoint = c3.getContents();
		RequestSpecification requestspecification = RestAssured.given();
		Response response = requestspecification.delete(endpoint + id);
		requestspecification.then();
		System.out.println(response.getStatusCode());
		System.out.println("record deleted.");
		System.out.println(response.asPrettyString());
		if(response.getStatusCode() == 204)
		{
			c.writeexcel("testcases", 12, 10, "passed");
		}
		else
		{
			c.writeexcel("testcases", 12, 10, "failed");
		}
  }
}
