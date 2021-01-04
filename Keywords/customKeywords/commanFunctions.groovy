package customKeywords
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

class commanFunctions {

	@Keyword
	public void openBrowser(){
		WebUI.openBrowser(GlobalVariable.Site_Detect_URL)
		WebUI.maximizeWindow()
		WebUI.waitForPageLoad(GlobalVariable.waitForPageLoad)
		//WebUI.deleteAllCookies()
	}

	// Admin log into Browser
	@Keyword
	public void logIntoBrowser(){

		WebUI.sendKeys(findTestObject('Object Repository/LoginPage/UserNameField'), GlobalVariable.AdminUserName)
		WebUI.sendKeys(findTestObject('Object Repository/LoginPage/PasswordField'), GlobalVariable.AdminPassWord)
		WebUI.scrollToElement(findTestObject('Object Repository/LoginPage/LoginBtn'), GlobalVariable.TimeOut)
		WebUI.click(findTestObject('Object Repository/LoginPage/LoginBtn'))
	}


	@Keyword
	public void otpLogin(){

		int i = 0
		String num = i.toString()

		WebUI.sendKeys(findTestObject('Object Repository/LoginPage/otpOne'), num)
		WebUI.sendKeys(findTestObject('Object Repository/LoginPage/otpTwo'), num)
		WebUI.sendKeys(findTestObject('Object Repository/LoginPage/otpThree'), num)
		WebUI.sendKeys(findTestObject('Object Repository/LoginPage/otpFour'), num)
		WebUI.sendKeys(findTestObject('Object Repository/LoginPage/otpFive'), num)

		WebUI.click(findTestObject('Object Repository/LoginPage/VerifyBtn'))
	}

	@Keyword
	public void passWordFieldAndClickOnLogin(String password){

		WebUI.sendKeys(findTestObject('Object Repository/LoginECM/PasswordField'), password)
		WebUI.scrollToElement(findTestObject('Object Repository/LoginECM/LogInBtn'), GlobalVariable.TimeOut)
		WebUI.click(findTestObject('Object Repository/LoginECM/LogInBtn'))
	}

	@Keyword
	public void homeLogOutBrowser(){
		WebUI.switchToDefaultContent()
		//WebUI.switchToWindowIndex(0)
		WebUI.click(findTestObject('Object Repository/LoginECM/LogOutBtn'))
	}

	@Keyword
	public void homeLogOutAndcloseBrowser(){
		WebUI.switchToDefaultContent()
		//WebUI.switchToWindowIndex(0)
		WebUI.click(findTestObject('Object Repository/LoginECM/LogOutBtn'))
		WebUI.closeBrowser()
	}

	@Keyword
	public void logOutBrowser(){
		WebUI.switchToDefaultContent()
		//WebUI.switchToWindowIndex(0)
		WebUI.click(findTestObject('Object Repository/LoginECM/LogOutInsideApp'))
	}

	@Keyword
	public void logOutAndcloseBrowser(){
		WebUI.switchToDefaultContent()
		//WebUI.switchToWindowIndex(0)
		WebUI.click(findTestObject('Object Repository/LoginECM/LogOutInsideApp'))
		WebUI.closeBrowser()
	}


	@Keyword
	public void onlyCloseBrowser(){

		WebUI.closeBrowser()
	}

	@Keyword
	public void navigateToManagement(){

		WebUI.click(findTestObject('Object Repository/HomePage/ProfileIcon'))
		WebUI.click(findTestObject('Object Repository/HomePage/management'))
	}





	/**
	 * Refresh browser
	 */
	@Keyword
	def refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh successfully")
	}

	/**
	 * Click element
	 * @param to Katalon test object
	 */
	@Keyword
	def clickElement(TestObject to) {
		try {
			WebElement element = WebUI.findWebElement(to);
			KeywordUtil.logInfo("Clicking element")
			element.click()
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}


	public void clickElementWithJS(TestObject element) {
		try {
			WebElement elementObject = WebUI.findWebElement(element)

			((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementObject)
			KeywordUtil.logInfo("Clicked on element with JS")
		} catch (Exception e) {
			KeywordUtil.logInfo("Exception while clicking on element with JS" + e.getMessage())
		}
	}



	/**
	 * To Upload Image using Robot class
	 *
	 * @param obj
	 * @param objName
	 * @param key
	 */
	@Keyword
	public void uploadImage(String key) {
		try {

			// put path to your image in a clipboard
			StringSelection ss = new StringSelection(key);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

			// imitate mouse events like ENTER, CTRL+C, CTRL+V
			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			KeywordUtil.logInfo("Image Uploaded Sucsessfully")
		} catch (Exception e) {
			KeywordUtil.markFailed("Exception while Uploading Image")
		}
	}




	@Keyword
	public void PastRequiredStr(String key) {

		// put path to your image in a clipboard
		StringSelection ss = new StringSelection(key);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// imitate mouse events like ENTER, CTRL+C, CTRL+V
		Robot robot = new Robot();

		//Past
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}





	/**
	 * To validate element is Enabled
	 * Element enabled
	 * @param to Katalon test object
	 */
	@Keyword
	def elementIsEnabled(TestObject to) {
		try {
			WebElement element = WebUI.findWebElement(to);
			KeywordUtil.logInfo("Finding element is enabled")


			if(element.isEnabled()){

				KeywordUtil.markPassed("Element is Enabled")
			}else{

				KeywordUtil.markFailed("Element has been disabled")
			}

		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to find an element enabled or not")
		}
	}

	/**
	 * To validate element is disabled
	 * 
	 * Element is disabled
	 * @param to Katalon test object
	 */
	@Keyword
	def elementIsDisabled(TestObject to) {
		try {
			WebElement element = WebUI.findWebElement(to);
			KeywordUtil.logInfo("Finding element is disabled")
			//element.enabled

			if(element.isEnabled()){

				KeywordUtil.markFailed("Element is Enabled")
			}else{

				KeywordUtil.markPassed("Element has been disabled")
			}

		} catch (WebElementNotFoundException e) {

			KeywordUtil.markFailed("Element not found")

		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to find an element disabled or not")
		}
	}

	/**
	 * To verify element is present on the page and return boolean
	 *
	 * @param obj
	 * @param elementName
	 * @return
	 */
	public boolean elementIsPresent(By obj) {

		int size = 0;
		try {

			WebDriver webDriver = DriverFactory.getWebDriver()
			size = webDriver.findElements(obj).size()

			System.out.print( size + "------------------------");

			KeywordUtil.logInfo("Element size " + size);

		} catch (Exception e) {

			KeywordUtil.markError("Exception while locating element" + e.getMessage());
		}

		return (size > 0) ? true : false;
	}

	@Keyword
	public boolean elementIsPresentOrNot(TestObject obj) {

		boolean result = false
		try {
			WebElement element = WebUI.findWebElement(obj)

			KeywordUtil.logInfo("Element is exist ")
			result = true
		} catch (Exception e) {

			result = false
			KeywordUtil.logInfo("Element is not exist ")

		}

		return result
	}



	/**
	 * Multiple windowHandle
	 *
	 * @param Index
	 */
	@Keyword
	public void windowHandle(int Index) {
		try {

			//Thread.sleep(15000);

			//WebElement element = WebUI.findWebElement(obj)
			WebDriver webDriver = DriverFactory.getWebDriver()
			Set<String> setOfWindows = webDriver.getWindowHandles();
			Object[] window = (setOfWindows.toArray());
			webDriver.switchTo().window((String) window[Index]);

			KeywordUtil.logInfo("Switched require window")
			//log(LogType.INFO, "Switched require window");
		} catch (Exception e) {

			KeywordUtil.markError("Exception while Switching to require window" + e.getMessage())

			//log(LogType.ERROR, "Exception while Switching to require window");
		}
	}

	//	WebDriver webDriver = DriverFactory.getWebDriver()



	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	def List<WebElement> getHtmlTableRows(TestObject  table , String outerTagName) {
		WebElement mailList = WebUI.findWebElement(table)
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}


	@Keyword
	public boolean iterateTableAndValidateOrganization(By locator, String text) {


		WebDriver webDriver = DriverFactory.getWebDriver()
		List<WebElement> AllData = webDriver.findElements(locator)
		println(AllData.size())

		for (WebElement e : AllData) {
			System.out.println("------>"+e.getText())

			if(e.getText().equals(text)){

				KeywordUtil.logInfo("[-------- Created organization is exist in the list ------] ")

				//return true
				return true
				//break

			}
		}
	}

	@Keyword
	public boolean iterateTableAndValidate(By locator, String text) {

		WebDriver webDriver = DriverFactory.getWebDriver()
		List<WebElement> AllData = webDriver.findElements(locator)
		println(AllData.size())

		for (WebElement e : AllData) {
			System.out.println("------>"+e.getText())

			if(e.getText().equals(text)){

				KeywordUtil.logInfo("[-------- Created organization is exist in the list ------] ")

				break
			}

		}
	}

	@Keyword
	public void iterateTableRowAndgetTextAndValidate(By locator, String text) {

		try {

			WebDriver webDriver = DriverFactory.getWebDriver()
			List<WebElement> tablesize = webDriver.findElements(locator)

			for (WebElement webElement : tablesize) {

				String actual = webElement.findElement(By.xpath(".//td[1]")).getText();

				if (actual.equals(text)) {

					KeywordUtil.logInfo("Validated Created organization name is : " + actual + " is present in the Table")

					break;
				}
			}

		} catch (Exception e) {

			KeywordUtil.markError("Exception while validate crated organization")

		}
	}


	@Keyword
	public List<WebElement> getDropDownValues(TestObject  dd,TestObject  ddoptions ) {

		WebElement mailList = WebUI.findWebElement(dd)
		List<WebElement> tablerows = mailList.findElements(ddoptions)

		for (int i = 0; i < tablerows.size(); i++) {
			System.out.println(tablerows.size());

			WebElement row = tablerows.get(i);

			System.out.println(row.getText());

			return tablerows

		}
	}

	@Keyword
	public String getRandomAlphaString(int siz) {
		//String SALTCHARS = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
		String SALTCHARS = 'abcdefghijklmnopqrstuvwxyz';
		StringBuilder builder = new StringBuilder();
		Random ran = new Random();
		while (builder.length()< siz) {
			int index = (int)(ran.nextFloat()*SALTCHARS.length());
			builder.append(SALTCHARS.charAt(index));
		}
		String saltStr = builder.toString();

		return saltStr
	}


	@Keyword
	public int getRandomNumbers() {
		// create instance of Random class

		Random r = new Random();
		int low = 10000;
		int high = 99999;
		int rand_int = r.nextInt(high-low) + low;

		return rand_int;
	}


	@Keyword
	public String uppCaseString(String LowerString) {

		String S1 = new String(LowerString)
		//Convert to UpperCase
		System.out.println(S1.toUpperCase())
		String uppString = S1.toUpperCase()

		return uppString
	}

	@Keyword
	public boolean VerifyListIsPresent(String iterate) {

		//TestObject ADBListXpath = getADBListTestObject(iterate)

		TestObject ADBListXpath

		boolean string = elementIsPresentOrNot(ADBListXpath)

		return string
	}


	private String getOtpXpath(String num) {

		return "//input[@id='otp"+ num +"']"

	}

	private TestObject getOtpTestObject(String listNo) {

		TestObject ADBListXpath = new TestObject(listNo);
		ADBListXpath.addProperty("xpath", ConditionType.EQUALS, getOtpXpath(listNo), true);
		return ADBListXpath

	}


	private String getIterateCellXpath(String iterate) {

		return "	//table/tbody/tr[" + iterate +"]/td[1]"

	}

	private TestObject getIterateCellXpathTestObject(String iterate) {

		TestObject IterateCellXpath = new TestObject(iterate);
		IterateCellXpath.addProperty("xpath", ConditionType.EQUALS, getIterateCellXpath(iterate), true);
		return IterateCellXpath

	}

}
