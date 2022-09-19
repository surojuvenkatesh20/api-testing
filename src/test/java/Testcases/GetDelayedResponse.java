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

public class GetDelayedResponse {
  @Test
  public void f() throws BiffException, IOException {
	  System.out.println("Delayed Response");
//	    File f = new File("C:\\Users\\Suroju Venkatesh\\eclipse-workspace\\api\\src\\test\\java\\testdata.xls");
//		Workbook wb = Workbook.getWorkbook(f);
//		Sheet sheet = wb.getSheet(2);
		  CommonExcelSheet c = new CommonExcelSheet();

	  Cell c1 = c.getsheet().getCell(1, 0);
	  RestAssured.baseURI = c1.getContents();
	  Cell c2 = c.getsheet().getCell(6, 17);
	  String endpoint = c2.getContents();
	  RequestSpecification req = RestAssured.given();
	  Response response = req.get(endpoint);
	  System.out.println(response.asPrettyString());
	  if(response.getStatusCode() == 200)
	  {
		  c.writeexcel("testcases", 12, 15, "passed");
	  }
	  else
	  {
		  c.writeexcel("testcases", 12, 15, "failed");
	  }
  }
}
