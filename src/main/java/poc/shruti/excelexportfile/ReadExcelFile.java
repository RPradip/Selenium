package poc.shruti.excelexportfile;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public Sheet readExcel(String filePath, String fileName, String sheetName) throws IOException {


	    InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(fileName);

		Workbook excelWorkbook = null;

		// Find the file extension by spliting file name in substing and getting only
		// extension name
		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		// Check condition if the file is xlsx file
		if (fileExtensionName.equals(".xlsx")) {

			// If it is xlsx file then create object of XSSFWorkbook class
			excelWorkbook = new XSSFWorkbook(inputStream);
		}

		// Check condition if the file is xls file
		else if (fileExtensionName.equals(".xls")) {

			// If it is xls file then create object of XSSFWorkbook class
			excelWorkbook = new HSSFWorkbook(inputStream);
		}

		// Read sheet inside the workbook by its name
		Sheet dataReportSheet = excelWorkbook.getSheet(sheetName);
		System.out.println("EXCEL FILE SHEET NAME IS " + sheetName + "EXTENSION OF FILE IS " + fileExtensionName);
		return dataReportSheet;
	}
}
