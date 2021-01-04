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

By obj = By.xpath("//table/tbody/tr/td[1]")

CustomKeywords.'customKeywords.commanFunctions.openBrowser'()

CustomKeywords.'customKeywords.commanFunctions.logIntoBrowser'()

WebUI.delay(11)

CustomKeywords.'customKeywords.commanFunctions.otpLogin'()

WebDriver webDriver = DriverFactory.getWebDriver()

//List<WebElement> namesElements = webDriver.findElements(obj)

List<WebElement> namesElements

List<String> Allnames = new ArrayList<String>()

By objTwo = By.xpath("//*[@title='Next Page']")

boolean str = CustomKeywords.'customKeywords.commanFunctions.elementIsPresent'(objTwo)

if(!str == true){

	List<WebElement> AllData = webDriver.findElements(obj)
	println(AllData.size())
	
	for (WebElement names : AllData) {
		System.out.println("------>"+names.getText())
		
	   if(names.getText().equals('TestOrg_15_11_2020')){
		 
			 KeywordUtil.logInfo("[--------Created list is exist------] ")
		
		   break
			  
	   }else {
	   
	   KeywordUtil.markFailed("[--------Created list is not exist------] ")
	   
	   }
		
	}
		
	
}else{


String strAttribute = WebUI.getAttribute(findTestObject('Object Repository/AdminOrgListPage/NextPageBtn'), 'class')
System.out.println("------> ---------- "+strAttribute)

while(!strAttribute.contains("disabled")){
	
	WebUI.click(findTestObject('Object Repository/AdminOrgListPage/NextPageBtn'))
	
	namesElements = webDriver.findElements(obj)
	
	for (WebElement namesElement : namesElements) {
		
		Allnames.add(namesElement.getText())

		KeywordUtil.logInfo("------> "+Allnames)
				
	   }
	
	strAttribute = WebUI.getAttribute(findTestObject('Object Repository/AdminOrgListPage/NextPageBtn'), 'class')
	
	}

   if(Allnames.contains('TestOrg_15_11_2020')){
	 
   KeywordUtil.logInfo("[--------Created list is exist------]")
		  
   }else{
   
   KeywordUtil.markFailed("[--------Created list is not exist------]")
   
   }

}