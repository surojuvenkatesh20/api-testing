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

public class GetAllResources {
  @Test
  public void f() throws BiffException, IOException {
//	    File f = new File("C:\\Users\\Suroju Venkatesh\\eclipse-workspace\\api\\src\\test\\java\\testdata.xls");
//		Workbook wb = Workbook.getWorkbook(f);
//		Sheet sheet = wb.getSheet(2);
		 CommonExcelSheet c = new CommonExcelSheet();

		Cell c1 = c.getsheet().getCell(1, 0);
		RestAssured.baseURI = c1.getContents();
		Cell c2 = c.getsheet().getCell(6, 6);
		String endpoint = c2.getContents();
	    System.out.println("Reading all resources");
		Response response = RestAssured.get(endpoint);
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asPrettyString());
		if(response.getStatusCode() == 200)
		{
			c.writeexcel("testcases", 12, 4, "passed");
		}
		else
		{
			c.writeexcel("testcases", 12, 4, "failed");
		}
  }
}
