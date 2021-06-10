package poc.shruti.main;

import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import poc.shruti.excelexportfile.ReadExcelFile;
import poc.shruti.operations.ReadLoginCredentials;
import poc.shruti.operations.UIProcessor;

public class Controller {

	public void processData() throws Exception {
		
		String ChromeDriverPath ="src\\main\\resources\\drivers\\chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver",ChromeDriverPath);
		WebDriver driver = new ChromeDriver();
		ReadExcelFile readexcelfile = new ReadExcelFile();
		ReadLoginCredentials readlogincredentials = new ReadLoginCredentials();
		Properties properties = readlogincredentials.getObjectRepository();
		UIProcessor processor = new UIProcessor(driver);

		// Read keyword sheet
		Sheet dataReportSheet = readexcelfile.readExcel("src\\main\\resources", "excelDataSheet.xlsx", "Credentials");
		// Find number of rows in excel file
		int rowCount = dataReportSheet.getLastRowNum() - dataReportSheet.getFirstRowNum();
		System.out.println("Row count is " + rowCount);

		// Create a loop over all the rows of excel file to read it
		for (int i = 1; i < rowCount + 1; i++) {

			// Loop over all the rows
			Row row = dataReportSheet.getRow(i);

			// Check if the first cell contain a value, if yes, That means it is the new
			if (row.getCell(0).toString().length() == 0) {

				// Print testcase detail on console
				System.out.println(row.getCell(1).toString() + "----- " + row.getCell(2).toString() + "----- "
						+ row.getCell(3).toString() + "----- " + row.getCell(4).toString());

				// Call perform function to perform operation on UI
				processor.perform(properties, row.getCell(1).toString(), row.getCell(2).toString(),
						row.getCell(3).toString(), row.getCell(4).toString());
			} else {
				// Print the new testcase name when it started
				System.out.println("New Testcase->" + row.getCell(0).toString() + " Started");
			}
		}

	}

	public static void main(String[] args) throws Exception {
		Controller controller = new Controller();
		controller.processData();
	}

}
