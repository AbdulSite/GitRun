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

By objTwo = By.xpath("//*[@title='Next Page']")

CustomKeywords.'customKeywords.commanFunctions.openBrowser'()

CustomKeywords.'customKeywords.commanFunctions.logIntoBrowser'()

//CustomKeywords.'customKeywords.commanFunctions.otpLogin'()

WebUI.delay(11)

WebDriver webDriver = DriverFactory.getWebDriver()

//List<WebElement> namesElements = webDriver.findElements(obj)

List<WebElement> namesElements

List<String> Allnames = new ArrayList<String>()

//Create organization 

WebUI.click(findTestObject('Object Repository/AddOrganizationPage/AddOrgBtn'))

String strOrg = CustomKeywords.'customKeywords.commanFunctions.getRandomAlphaString'(5)

String orgName = 'TestOrg_'+ strOrg

WebUI.sendKeys(findTestObject('Object Repository/AddOrganizationPage/OrgInputField'), orgName)

WebUI.sendKeys(findTestObject('Object Repository/AddOrganizationPage/OrgUrlInputField'), 'www.testOrg.com')

WebUI.click(findTestObject('Object Repository/AddOrganizationPage/SelectOrSearchSector'))

String str_copy = 'Fi'

CustomKeywords.'customKeywords.commanFunctions.PastRequiredStr'(str_copy)

WebUI.click(findTestObject('Object Repository/AddOrganizationPage/SectorFirstList'))

WebUI.sendKeys(findTestObject('Object Repository/AddOrganizationPage/FirstName'), 'Abdul')

WebUI.sendKeys(findTestObject('Object Repository/AddOrganizationPage/LastName'), 'Rahaman')

String strTwo = CustomKeywords.'customKeywords.commanFunctions.getRandomAlphaString'(5)

String email = 'test_'+ strTwo + '@email.com'

WebUI.sendKeys(findTestObject('AddOrganizationPage/EmailField'), email)

int num = 2

int numTwo = 2

String strThree = num.toString()

String strFour = numTwo.toString()

WebUI.sendKeys(findTestObject('Object Repository/AddOrganizationPage/UserLimit'), strThree)

WebUI.sendKeys(findTestObject('Object Repository/AddOrganizationPage/TargetLimit'), strFour)

WebUI.click(findTestObject('Object Repository/AddOrganizationPage/EndDate'))

WebUI.sendKeys(findTestObject('Object Repository/AddOrganizationPage/CalSelectDurationInput'), strFour)

WebUI.click(findTestObject('Object Repository/AddOrganizationPage/CalOKBtn'))

WebUI.click(findTestObject('Object Repository/AddOrganizationPage/AddOrgInnerBtn'))

//Pop ups
WebUI.click(findTestObject('Object Repository/AddOrganizationPage/ProceedBtn'))

WebUI.click(findTestObject('Object Repository/AddOrganizationPage/CloseBtn'))

WebUI.click(findTestObject('Object Repository/AddOrganizationPage/DetectImg'))


//Verify created Organization is present in the list 


boolean str = CustomKeywords.'customKeywords.commanFunctions.elementIsPresent'(objTwo)

if(!str == true){

	List<WebElement> AllData = webDriver.findElements(obj)
	println(AllData.size())
	
	for (WebElement names : AllData) {
		System.out.println("------>"+names.getText())
		
	   if(names.getText().equals(orgName)){
		 
			 KeywordUtil.logInfo("[--------Created " +orgName +" is exist in list------]")
		
		   break
			  
	   }else {
	   
	   KeywordUtil.markFailed("[--------Created " +orgName +" is not exist in list------]")
	   
	   }
		
	}
		
	
}else{


String strAttribute = WebUI.getAttribute(findTestObject('Object Repository/AdminOrgListPage/NextPageBtn'), 'class')
System.out.println("------> ---------- "+strAttribute)

while(!strAttribute.contains("disabled")){
	
	
	namesElements = webDriver.findElements(obj)
	
	for (WebElement namesElement : namesElements) {
		
		Allnames.add(namesElement.getText())

		KeywordUtil.logInfo("------> "+Allnames)
				
	   }
	
	WebUI.click(findTestObject('Object Repository/AdminOrgListPage/NextPageBtn'))
	
	strAttribute = WebUI.getAttribute(findTestObject('Object Repository/AdminOrgListPage/NextPageBtn'), 'class')
	
	}

   if(Allnames.contains(orgName)){
	 
   KeywordUtil.logInfo("[--------Created " +orgName +" is exist in list------]")
		  
   }else{
   
   KeywordUtil.markFailed("[--------Created " +orgName +" is not exist in list------]")
   
   }

}

//CustomKeywords.'customKeywords.commanFunctions.logOutAndcloseBrowser'()