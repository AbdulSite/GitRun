import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.By
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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil


By obj = By.xpath("//*[@id='example_length']/..//table/tbody/tr/td[1]")

//CustomKeywords.'customKeywords.commanFunctions.openBrowser'()
//CustomKeywords.'customKeywords.commanFunctions.logIntoBrowser'()

WebUI.openBrowser('')

WebUI.navigateToUrl('https://datatables.net/')

WebUI.delay(8)
//CustomKeywords.'customKeywords.commanFunctions.otpLogin'()

//By objPageCount = By.xpath("//ul[@class='ant-pagination ng-star-inserted']//a")

WebDriver webDriver = DriverFactory.getWebDriver()

List<WebElement> namesElements = webDriver.findElements(obj)

List<String> names = new ArrayList<String>()


for (WebElement namesElement : namesElements) {
	
	names.add(namesElement.getText())

	KeywordUtil.logInfo("------> "+names)
	System.out.println("------> "+names)
	
   }


//String strAttribute = WebUI.getAttribute(findTestObject('Object Repository/WebTableObjects/pageList'), 'class')
String strAttribute = WebUI.getAttribute(findTestObject('Object Repository/WebTableObjects/PagiNextbtn'), 'class')
System.out.println("------> ---------- "+strAttribute)

while(!strAttribute.contains("disabled")){
	
	//WebUI.click(findTestObject('Object Repository/WebTableObjects/pageList'))
	WebUI.click(findTestObject('Object Repository/WebTableObjects/PagiNextbtn'))
	
	namesElements = webDriver.findElements(obj)
	
	for (WebElement namesElement : namesElements) {
		
		names.add(namesElement.getText())

		//KeywordUtil.logInfo("------> "+names)
				
	   }
	
	//strAttribute = WebUI.getAttribute(findTestObject('Object Repository/WebTableObjects/pageList'), 'class')
	strAttribute = WebUI.getAttribute(findTestObject('Object Repository/WebTableObjects/PagiNextbtn'), 'class')
	
	}

   if(names.contains('Zorita Serrano')){
	 
		 KeywordUtil.logInfo("[--------Created list is exist------]")
		  
   }else{
   
   KeywordUtil.markFailed("created list is not exist")
   
   }
