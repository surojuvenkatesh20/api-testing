package Testcases;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import utilities.CommonExcelSheet;

public class GetSingleUser {
  @Test
  public void f() throws BiffException, IOException {
//	  File f = new File("C:\\Users\\Suroju Venkatesh\\eclipse-workspace\\api\\src\\test\\java\\testdata.xls");
//	  Workbook wb = Workbook.getWorkbook(f);
//	  Sheet sheet = wb.getSheet(2);
	  CommonExcelSheet c = new CommonExcelSheet();

	  System.out.println("Reading single user");
	  Cell c1 = c.getsheet().getCell(1,0);
	  RestAssured.baseURI = c1.getContents();
	  Cell c2 = c.getsheet().getCell(5, 4);
	  String id = c2.getContents();
	  Cell c3 = c.getsheet().getCell(6, 4);
	  String endpoint = c3.getContents();
	  Response response = RestAssured.get(endpoint + id);
	  System.out.println(response.getStatusLine());
	  System.out.println(response.getTime());
	  System.out.println(response.getBody().asPrettyString());
	  if(response.getStatusCode() == 200)
		{
			c.writeexcel("testcases", 12, 2, "passed");
		}
		else
		{
			c.writeexcel("testcases", 12, 2, "failed");
		}
  }
  
}
