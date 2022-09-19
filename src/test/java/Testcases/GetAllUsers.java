package Testcases;
import utilities.CommonExcelSheet;
//import java.io.File;
import java.io.IOException;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import jxl.Cell;
//import jxl.Sheet;
//import jxl.Workbook;
import jxl.read.biff.BiffException;
//import utilities.CommonExcelSheet;
import jxl.write.WritableSheet;

public class GetAllUsers{

@Test
  public void f() throws BiffException, IOException {
	  CommonExcelSheet g = new CommonExcelSheet();
//	  File f = new File("C:\\Users\\Suroju Venkatesh\\eclipse-workspace\\api\\src\\test\\java\\testdata.xls");
//	  Workbook wb = Workbook.getWorkbook(f);
//	  Sheet sheet = wb.getSheet(2);
	  System.out.println("Reading all users");
	  Cell c1 = g.getsheet().getCell(1,0);
	  String baseURI = c1.getContents();
	  RestAssured.baseURI = baseURI;
	  Cell c2 = g.getsheet().getCell(6, 3);
	  String endpoint = c2.getContents();
	  Response response = RestAssured.get(endpoint);
	  System.out.println(response.getStatusCode());
	  int statusCode = response.getStatusCode();
	  System.out.println(response.getStatusLine());
	  System.out.println(response.getTime());
	  System.out.println(response.getBody().asPrettyString());
	  if(statusCode == 200)
	  {
		  g.writeexcel("testcases", 12, 1, "passed");
	  }
	  else
	  {
		  g.writeexcel("testcases", 12, 1, "failed");
	  }
  }
}
