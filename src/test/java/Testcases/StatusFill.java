package Testcases;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class StatusFill {
	public StatusFill() throws IOException, RowsExceededException, WriteException
	{
		File f = new File("C:\\Users\\Suroju Venkatesh\\eclipse-workspace\\api\\src\\test\\java\\status.xls");
		WritableWorkbook wb = Workbook.createWorkbook(f);
		WritableSheet sheet = wb.createSheet("TestCasestatus", 0);
		Label l = new Label(0, 0, "Status");
		sheet.addCell(l);
		wb.write();
		wb.close();
	}
	public StatusFill(int r, int c, String status)
	{
		Label l1 = new Label(r, c, status);
	}
public static void main(String[] args) throws BiffException, IOException, RowsExceededException, WriteException {
	
}
}
