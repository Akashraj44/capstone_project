package utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.*;

public class ExcelUtils {

	public static String getData(String sheet,int row,int cell)throws Exception {
		FileInputStream fis =new FileInputStream("project.xlsx");
		XSSFWorkbook wb =new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet(sheet);
		return sh.getRow(row).getCell(cell).getStringCellValue();
	}
}