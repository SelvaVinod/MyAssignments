package MarathonThree14Nov;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelM2 {
	public static String[][] readData() throws IOException{
		 XSSFWorkbook wb=new XSSFWorkbook("./ExcelData/Marathon3TC2Question.xlsx");
		   XSSFSheet ws = wb.getSheetAt(0);
		   int rowCount = ws.getLastRowNum();
		   int colCount= ws.getRow(0).getLastCellNum();
		   String[][] data= new String [rowCount][colCount];
		   for(int i=1;i<=rowCount;i++) {
				for(int j=0;j<colCount;j++) {
			
			XSSFRow row = ws.getRow(i);
			XSSFCell cell = row.getCell(j);
			String cellValue = cell.getStringCellValue();
			data[i-1][j] = cellValue;
			System.out.println(data);
				}
			}
		   wb.close();
		return data;
		
		
	}


}
