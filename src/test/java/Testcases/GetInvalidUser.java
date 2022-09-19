package Testcases;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
//import io.restassured.response.ResponseBody;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import utilities.CommonExcelSheet;

public class GetInvalidUser {
  @Test
  public void f() throws BiffException, IOException {
//	    File f = new File("C:\\Users\\Suroju Venkatesh\\eclipse-workspace\\api\\src\\test\\java\\testdata.xls");
//		Workbook wb = Workbook.getWorkbook(f);
//		Sheet sheet = wb.getSheet(2);
	  CommonExcelSheet c = new CommonExcelSheet();
		Cell c1 = c.getsheet().getCell(1, 0);
		RestAssured.baseURI = c1.getContents();
		Cell c2 = c.getsheet().getCell(5, 5);
		String id = c2.getContents();
		Cell c3 = c.getsheet().getCell(6, 5);
		String endpoint = c3.getContents();
		Response response = RestAssured.get(endpoint + id);
//		ResponseBody res = response.getBody();
//		System.out.println(res.asPrettyString());
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusCode());
//		System.out.println(response.getBody().asPrettyString());
		System.out.println("User not exists");
		if(response.getStatusCode() == 404)
		{
			c.writeexcel("testcases", 12, 3, "passed");
		}
		else
		{
			c.writeexcel("testcases", 12, 3, "failed");
		}
  }
}
