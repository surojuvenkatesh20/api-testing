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

public class GetUsersList {
  @Test
  public void f() throws BiffException, IOException {
//	  File f = new File("C:\\Users\\Suroju Venkatesh\\eclipse-workspace\\api\\src\\test\\java\\testdata.xls");
//	  Workbook wb = Workbook.getWorkbook(f);
//	  Sheet sheet = wb.getSheet(2);
	  CommonExcelSheet g = new CommonExcelSheet();
	  Cell c1 = g.getsheet().getCell(1,0);
	  System.out.println("Reading users list");
		RestAssured.baseURI = c1.getContents();
		Cell c2 = g.getsheet().getCell(6, 3);
		String endpoint = c2.getContents();
		Response response = RestAssured.get(endpoint);
//		ResponseBody res = response.getBody();
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asPrettyString());
		System.out.println("Resource not exists");
		if(response.getStatusCode() == 200)
		  {
			  g.writeexcel("testcases", 12, 1, "passed");
		  }
		  else
		  {
			  g.writeexcel("testcases", 12, 1, "failed");
		  }
  }
}
