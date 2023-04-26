package account

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI




public class KwLogin {
	@Keyword
	public void openbrowser() {
		WebUI.openBrowser('')
		WebUI.waitForPageLoad(30)
		WebUI.maximizeWindow()
		WebUI.navigateToUrl('practice.automationtesting.in')
		WebUI.waitForPageLoad(5)
		WebUI.click(findTestObject('Home_Page/lbl_MyAccount'))
	}
}

public class Login {
	@Keyword
	def login (String username, String password) {
		WebUI.waitForElementPresent(findTestObject('Login_Page/input_username'), 20)
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('Login_Page/input_username'))
		WebUI.waitForPageLoad(10)
		WebUI.setText(findTestObject('Login_Page/input_username'), username)
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('Login_Page/input_pw'))
		WebUI.waitForPageLoad(10)
		WebUI.setEncryptedText(findTestObject('Login_Page/input_pw'), password)
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('Login_Page/btn_login'))
	}
}

public class idOrder{
	@Keyword
	public void listelement(){
		List<WebElement> elements = WebUiCommonHelper.findWebElements(findTestObject('Orders_Page/id_oder'), 30);
		WebElement randomElement = elements.get(new Random().nextInt(elements.size()));
		randomElement.click();
	}
}
