package Testcases;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import groovyjarjarantlr4.v4.parse.ANTLRParser.labeledAlt_return;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelStatusFill {
  @Test
  public void f() throws BiffException, IOException, RowsExceededException, WriteException {
	  File f = new File("C:\\Users\\Suroju Venkatesh\\eclipse-workspace\\api\\src\\test\\java\\testdata.xls");
		WritableWorkbook wb = Workbook.createWorkbook(f);
		WritableSheet sheet = wb.createSheet("TestCasestatus", 0);
		Label l = new Label(0, 0, "Status");
		sheet.addCell(l);
		wb.write();
		wb.close();	  
  }
//  public void applystatus(int r, int c, String status)
//  {
//	  Label l = new Label(r, c, status);
////	  sheet.addCell();
//  }
}
