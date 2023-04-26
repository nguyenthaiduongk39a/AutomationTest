package datafile

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.poi.ss.usermodel.Row
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable
import com.kms.katalon.core.configuration.RunConfiguration
import org.apache.poi.xssf.usermodel.XSSFRow


//create excel file
public class CrtFileExcel {
	@Keyword
	def static void FileExcel(String filePath, String sheetname, String user1, String pw1, String user2, String pw2, String user3, String pw3) {

		// Create an instance of XSSFWorkbook class
		XSSFWorkbook workbook = new XSSFWorkbook()

		// Create a sheet
		def sheet = workbook.createSheet(sheetname)

		// Define column headers
		Row row = sheet.createRow(0)
		row.createCell(0).setCellValue("Username")
		row.createCell(1).setCellValue("Password")

		// Define data for column 1
		row = sheet.createRow(1)
		row.createCell(0).setCellValue(user1)
		row.createCell(1).setCellValue(pw1)

		row = sheet.createRow(2)
		row.createCell(0).setCellValue(user2)
		row.createCell(1).setCellValue(pw2)

		row = sheet.createRow(3)
		row.createCell(0).setCellValue(user3)
		row.createCell(1).setCellValue(pw3)

		// Write the workbook object to the file
		workbook.write(new FileOutputStream(filePath))
		workbook.close()

		// Log message to indicate that the file has been created successfully
		KeywordUtil.logInfo("Excel file created successfully at ${filePath}")
	}
}

public class ReadExcelData {
	@Keyword
	def static List<Map<String, String>> readDataFromExcel(String filePath, String sheetName) {
		List<Map<String, String>> testData = new ArrayList<Map<String, String>>()
		XSSFWorkbook workbook = null
		try {
			workbook = new XSSFWorkbook(new FileInputStream(filePath))
			def sheet = workbook.getSheet(sheetName)
			def rowIterator = sheet.iterator()
			def headers = []
			while (rowIterator.hasNext()) {
				def row = rowIterator.next() as XSSFRow
				if (row.getRowNum() == 0) {
					row.each { cell ->
						headers.add(cell.getStringCellValue())
					}
				} else {
					def map = [:]
					row.eachWithIndex { cell, index ->
						if (headers[index]) {
							map.put(headers[index], cell.getStringCellValue())
						}
					}
					testData.add(map)
				}
			}
		} catch (Exception e) {
			KeywordUtil.markFailed("Exception occurred while reading data from Excel file: " + e.getMessage())
		} finally {
			if (workbook != null) {
				workbook.close()
			}
		}
		return testData
	}
}


public class UpdateExcelData {
	@Keyword
	def static void updateData(String fileName, String sheetName, int rowNum, int colNum, String value) {
		String filePath = RunConfiguration.getProjectDir() + "/Test Data/" + fileName
		XSSFWorkbook workbook = null
		try {
			workbook = new XSSFWorkbook(new FileInputStream(filePath))
			def sheet = workbook.getSheet(sheetName)
			def row = sheet.getRow(rowNum)
			def cell = row.getCell(colNum)
			cell.setCellValue(value)
			FileOutputStream outputStream = new FileOutputStream(filePath)
			workbook.write(outputStream)
			outputStream.close()
		} catch (Exception e) {
			println("Exception occurred while updating data in Excel file: " + e.getMessage())
		} finally {
			if (workbook != null) {
				workbook.close()
			}
		}
	}
}

public class DeleteExcelData {
	@Keyword
	def static void deleteData(String fileName, String sheetName, int rowNum, int colNum) {
		String filePath = RunConfiguration.getProjectDir() + "/Test Data/" + fileName
		XSSFWorkbook workbook = null
		try {
			workbook = new XSSFWorkbook(new FileInputStream(filePath))
			def sheet = workbook.getSheet(sheetName)
			def row = sheet.getRow(rowNum)
			def cell = row.getCell(colNum)
			cell.setCellValue("")
			FileOutputStream outputStream = new FileOutputStream(filePath)
			workbook.write(outputStream)
			outputStream.close()
		} catch (Exception e) {
			println("Exception occurred while deleting data from Excel file: " + e.getMessage())
		} finally {
			if (workbook != null) {
				workbook.close()
			}
		}
	}
}