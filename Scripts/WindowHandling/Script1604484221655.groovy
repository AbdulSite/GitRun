import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.kotak.com/en.html')

WebUI.maximizeWindow()

//WebUI.sendKeys(findTestObject('Object Repository/WebTableObjects/TableData'), "Selenium")

WebUI.waitForPageLoad(GlobalVariable.TimeOut)

//WebUI.delay(8)

WebUI.click(findTestObject('Object Repository/WebTableObjects/clickOneInWindow'))

//int num = WebUI.getWindowIndex()
//String str = WebUI.getWindowTitle()

//KeywordUtil.logInfo("[--------Window index------] "+ num)
//KeywordUtil.logInfo("[--------Window index------] "+ str) //W3Schools Online Web Tutorials

//WebUI.switchToWindowTitle('Tryit Editor v3.6')

WebUI.delay(2)

//String i = 1.toString()

//CustomKeywords.'customKeywords.commanFunctions.windowHandle'(1)

WebUI.switchToWindowIndex(1)

//WebUI.switchToWindowIndex(0)
//WebUI.switch


//WebUI.waitForPageLoad(GlobalVariable.TimeOut)
//https://www.w3schools.com/html/tryit.asp?filename=tryhtml_default


/*

WebUI.delay(5)

WebUI.switchToWindowIndex(1)

WebUI.click(findTestObject('Object Repository/WebTableObjects/HomeLink'))

WebUI.closeWindowIndex(1)

WebUI.delay(5)

WebUI.switchToWindowIndex(0)

WebUI.closeBrowser()

*/