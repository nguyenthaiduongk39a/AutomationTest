import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import java.lang.String
import groovy.transform.Field
CustomKeywords.'product.buyproduct.viewbasket'()

//Now user can find total and subtotal values just above the Proceed to Checkout button.
WebUI.verifyTextPresent("Subtotal", false)
WebUI.verifyTextPresent("Total", false)

CustomKeywords.'product.Total1.comparetotal'()

//Take Screenshot
WebUI.takeScreenshot('PicturePractice/TC15.png')

WebUI.delay(5)
WebUI.closeBrowser()

