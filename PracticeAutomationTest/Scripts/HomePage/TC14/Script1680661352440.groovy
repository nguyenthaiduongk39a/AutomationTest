import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

CustomKeywords.'product.buyproduct.viewbasket'()
//Click on textbox value under quantity in Check out page to add or subtract books
WebUI.setText(findTestObject('Details_Product/lbl_qty'),
	'3')

//Now after the above change ‘Update Basket’ button will turn into Clickable mode
WebUI.verifyElementClickable(findTestObject('ShoppingCart_Page/btn_updatebasket'))

//Click on Update Basket
WebUI.click(findTestObject('ShoppingCart_Page/btn_updatebasket'))

//Take Screenshot
WebUI.takeScreenshot('PicturePractice/TC14.png')

WebUI.delay(5)
WebUI.closeBrowser()

ExcelKeywords.create

