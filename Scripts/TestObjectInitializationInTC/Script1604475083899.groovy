import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//TestObject obj = findTestObject('Object Repository/WebTableObjects/UserName')
By obj = By.xpath("//input[@id='id_usernameeee']")

KeywordUtil.logInfo("[--------This method------] "+ obj)

WebUI.openBrowser('https://postal.test.site.sa/')

boolean str = CustomKeywords.'customKeywords.commanFunctions.elementIsPresent'(obj)
//boolean str = elementIsPresent(obj)

KeywordUtil.logInfo("[--------This method------] "+ str)


/*

By accountsbutton = By.xpath("//select[@id='day']/option")

WebUI.openBrowser('https://www.facebook.com/campaign/landing.php?campaign_id=1653993517&extra_1=s%7Cc%7C318504236042%7Ce%7Cfacebook%20%27%7C&placement=&creative=318504236042&keyword=facebook%20%27&partner_id=googlesem&extra_2=campaignid%3D1653993517%26adgroupid%3D63066387003%26matchtype%3De%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-360705453827%26loc_physical_ms%3D9040205%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gclid=CjwKCAiAv4n9BRA9EiwA30WND0vEgeTTJ5OHV8W_kuYqxjPVfNXCCBQ3U3t4ESFTzwdxIAxOYLkMkhoC_fUQAvD_BwE')


WebDriver webDriver = DriverFactory.getWebDriver()
List<WebElement> dates = webDriver.findElements(accountsbutton)
println(dates.size())

for (WebElement e : dates) {
	System.out.println("------>"+e.getText())
	
   if(e.getText().equals('20')){
	   
	e.click()
	break
	      
   }	
	
}


*/