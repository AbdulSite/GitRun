import org.openqa.selenium.By

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

By obj = By.xpath("//table[@id='customers']/tbody/tr/td")
//TestObject obj = findTestObject('Object Repository/WebTableObjects/TableData')

WebUI.openBrowser("https://www.w3schools.com/html/html_tables.asp")

WebUI.maximizeWindow()

String text = "Helen Bennett"

CustomKeywords.'customKeywords.commanFunctions.iterateTableAndValidateOrganization'(obj, text)

/*
WebDriver webDriver = DriverFactory.getWebDriver()
List<WebElement> AllData = webDriver.findElements(accountsbutton)
println(AllData.size())

for (WebElement e : AllData) {
	System.out.println("------>"+e.getText())
	
   if(e.getText().equals('Helen Bennett')){
	 
	     KeywordUtil.logInfo("[--------Created list is exist------] ")
	
	   break
		  
   }
	
}

WebUI.closeBrowser()

*/