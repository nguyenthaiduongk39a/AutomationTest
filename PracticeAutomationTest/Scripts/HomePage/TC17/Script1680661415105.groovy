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

//Verify user can find total and subtotal values just above the Proceed to Checkout button.
WebUI.verifyTextPresent("Subtotal", false)
WebUI.verifyTextPresent("Total", false)
WebUI.waitForPageLoad(5)

//Clicking on Proceed to Checkout button leads to payment gateway page
WebUI.click(findTestObject('ShoppingCart_Page/btn_ProceedToCheckout'))
WebUI.waitForPageLoad(5)

//User can view Billing Details,Order Details,Additional details and Payment gateway details.
WebUI.verifyTextPresent("Billing Details", false)
WebUI.verifyTextPresent("Your order", false)
WebUI.verifyTextPresent("Additional Information", false)
WebUI.verifyElementPresent(findTestObject('Checkout_Page/table_payment'), 5)

//User can fill his details in billing details form and can opt any payment in the payment gateway like Direct bank transfer,cheque,cash or paypal.
WebUI.click(findTestObject('Checkout_Page/coupon'))
WebUI.waitForPageLoad(3)
WebUI.setText(findTestObject('Checkout_Page/input_coupon'), coupon)
WebUI.setText(findTestObject('Checkout_Page/input_firstname'), firstname)
WebUI.setText(findTestObject('Checkout_Page/input_lastname'), lastname)
WebUI.setText(findTestObject('Checkout_Page/email'), email)
WebUI.setText(findTestObject('Checkout_Page/phone'), phone)
WebUI.click(findTestObject('Checkout_Page/country'))
WebUI.scrollToElement(findTestObject('Checkout_Page/input_country'), 5)
WebUI.waitForElementPresent(findTestObject('Checkout_Page/input_country'), 5)
WebUI.click(findTestObject('Checkout_Page/input_country'))
WebUI.setText(findTestObject('Checkout_Page/address'), address)
WebUI.setText(findTestObject('Checkout_Page/lbl_city'), city)
WebUI.setText(findTestObject('Checkout_Page/zip'), zip)
//Take Screenshot
WebUI.takeScreenshot('PicturePractice/TC17.png')

WebUI.delay(5)
WebUI.closeBrowser()
