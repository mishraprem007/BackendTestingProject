package ddt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author Premshankar Mishra
 */
public class ExcelUtility {

	String testDataPath = "./testData/testData_RestAssured.xlsx";
	
	/**
	 * read data from excel based on row and column index
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return
	 * @throws IOException
	 * @throws EncryptedDocumentException
	 * @throws Throwable
	 */

	public String getDataFromExcel(String sheetName, int rowNum, int cellNum)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(testDataPath);
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).toString();
		wb.close();
		return data;
	}

	/**
	 * get the used row count based on sheetName
	 * 
	 * @param sheetName
	 * @return
	 * @throws IOException
	 * @throws EncryptedDocumentException
	 * @throws Throwable
	 */

	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(testDataPath);
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;
	}

	/**
	 * write data back to excel based on cell index
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public void setDataIntoExcel(String sheetName, int rowNum, int cellNum)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(testDataPath);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
		FileOutputStream fos = new FileOutputStream(testDataPath);
		wb.write(fos);
		wb.close();

	}

}
