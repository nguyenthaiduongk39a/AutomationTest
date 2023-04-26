package product

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

import internal.GlobalVariable

public class buyproduct {
	@Keyword
	public void viewbasket() {
		//Open the browser
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.waitForPageLoad(5)

		//Enter the URL “http://practice.automationtesting.in/”
		WebUI.navigateToUrl('practice.automationtesting.in')
		WebUI.waitForPageLoad(5)

		//Click on Shop Menu
		WebUI.click(findTestObject('Home_Page/lbl_Shop'))
		WebUI.waitForPageLoad(5)

		//Now click on Home menu button
		WebUI.waitForElementPresent(findTestObject('Shop_Page/lbl_home'), 5)
		WebUI.click(findTestObject('Shop_Page/lbl_home'))
		WebUI.waitForPageLoad(5)
		//Test whether the Home page has Three Arrivals only
		WebUI.verifyElementPresent(findTestObject('Home_Page/array1'), 5)
		WebUI.click(findTestObject('Home_Page/btn_next'))
		WebUI.verifyElementPresent(findTestObject('Home_Page/array2'), 5)
		WebUI.click(findTestObject('Home_Page/btn_next'))
		WebUI.verifyElementPresent(findTestObject('Home_Page/array3'), 5)
		//The Home page must contains only three Arrivals
		WebUI.verifyElementPresent(findTestObject('Home_Page/array4'), 5)
		WebUI.verifyElementPresent(findTestObject('Home_Page/array5'), 5)
		WebUI.verifyElementPresent(findTestObject('Home_Page/array6'), 5)
		//Now click the image in the Arrivals
		WebUI.scrollToElement(findTestObject('Shop_Page/img_arrivals'), 5)
		WebUI.click(findTestObject('Shop_Page/img_arrivals'))
		WebUI.waitForPageLoad(5)
		//Click on the Add To Basket button which adds that book to your basket
		WebUI.click(findTestObject('Details_Product/btn_addtobasket'))
		WebUI.waitForPageLoad(5)

		//Now click on Item link which navigates to proceed to check out page
		WebUI.click(findTestObject('Details_Product/btn_viewbasket'))
		WebUI.waitForPageLoad(5)
	}
}

//Keyword so sanh gia
public class Total1 {
	@Keyword
	public void comparetotal() {
		String subtotalWithCurrencySymbol = WebUI.getText(findTestObject('ShoppingCart_Page/subtotal'))
		String totalWithCurrencySymbol = WebUI.getText(findTestObject('ShoppingCart_Page/total'))
		String currencySymbol = "₹"
		String subtotal = subtotalWithCurrencySymbol.replace(currencySymbol, "").trim()
		String total = totalWithCurrencySymbol.replace(currencySymbol, "").trim()
		assert subtotal.toFloat() < total.toFloat()
	}
}

