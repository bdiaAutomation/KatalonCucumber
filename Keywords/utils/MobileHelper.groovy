package utils
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import ch.qos.logback.core.joran.conditional.ElseAction
import groovy.json.StringEscapeUtils
import internal.GlobalVariable
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileAbstractKeyword
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.MobileTestObject.MobileLocatorStrategy
import com.kms.katalon.core.mobile.helper.MobileCommonHelper
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import org.openqa.selenium.StaleElementReferenceException


// TODO All pages class nedd to extends this one ===> Rename this class BaseTest
class MobileHelper {

	private WebDriverWait wait;
	protected final static int WAIT_TIMEOUT = GlobalVariable.explicitWait;

	/**
	 * Constructor of class
	 * Initialize webdriver wait 
	 */
	public MobileHelper() {
		AppiumDriver<?> driver = MobileDriverFactory.getDriver();
		wait = new WebDriverWait(driver, WAIT_TIMEOUT );
	}
	/**
	 * Check if element present in timeout
	 * @param to Katalon test object
	 * @param timeout time to wait for element to show up
	 * @return true if element present, otherwise false
	 */
	@Keyword
	def isElementPresent_Mobile(TestObject to, int timeout){
		try {
			KeywordUtil.logInfo("Finding element with id:" + to.getObjectId())

			WebElement element = MobileElementCommonHelper.findElement(to, timeout)
			if (element != null) {
				KeywordUtil.markPassed("Object " + to.getObjectId() + " is present")
			}
			return true
		} catch (Exception e) {
			KeywordUtil.markFailed("Object " + to.getObjectId() + " is not present")
		}
		return false;
	}

	@Keyword
	def isElementPresent_Error_Not_Throw(TestObject to, int timeout){
		try {
			KeywordUtil.logInfo("Finding element with id:" + to.getObjectId())

			WebElement element = MobileElementCommonHelper.findElement(to, timeout)
			if (element != null) {
				KeywordUtil.markPassed("Object " + to.getObjectId() + " is present")
			}
			return true
		} catch (Exception e) {
			KeywordUtil.logInfo("Object " + to.getObjectId() + " is not present")
		}
		return false;
	}


	/**
	 * Wait for visibility of TestObject  
	 * @param to Katalon test object
	 * @return MobileElement
	 */
	@Keyword
	def waitForVisibilityOfElement(TestObject to) {
		wait.until(ExpectedConditions.visibilityOf(MobileElementCommonHelper.findElement(to, WAIT_TIMEOUT)));
	}


	/**
	 * 
	 * @param to Katalon testObject
	 * @param timeOutInSeconds
	 * @return true if katalon testObject is visible
	 * else return false 
	 */
	@Keyword
	public Boolean isDisplayed(final TestObject to, long timeOutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(MobileDriverFactory.getDriver(), timeOutInSeconds);
			return wait.until(new ExpectedCondition<Boolean>() {
						@Override
						public Boolean apply(WebDriver driver) {

							if( (Mobile.getAttribute(to, "visible", timeOutInSeconds).equalsIgnoreCase("true")) || ((Mobile.getAttribute(to, "visible", timeOutInSeconds)).equalsIgnoreCase("1")) ) {
								KeywordUtil.markPassed("Object " + to.getObjectId() + " is visible")
								return true;
							} else {

								KeywordUtil.markFailed("Object " + to.getObjectId() + " is not visible")
								return false;
							}
						}
					});
		} catch (Exception ex) {
			KeywordUtil.markFailed("Object " + to.getObjectId() + " is not visible")
			return false;
		}
	}

	/**
	 * 
	 * @param to Katalon testObject
	 * tap on element 
	 * throw a TimeoutException if expected timeout occur 
	 */
	@Keyword
	public void tap(TestObject to) {
		KeywordUtil.logInfo("Tap on element : + " +  to);
		Mobile.waitForElementPresent(to, WAIT_TIMEOUT);
		Mobile.tap(to, WAIT_TIMEOUT);
	}

	/**
	 * Wait for Alert
	 */
	@Keyword
	public void waitForAlertToBePresent() {
		wait.until(ExpectedConditions.alertIsPresent());
	}

	/**
	 * Refresh screen 
	 * @param to Katalon TestObject
	 * @return
	 */
	@Keyword
	def refreshScreen(TestObject to) {
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf( MobileElementCommonHelper.findElement(to, WAIT_TIMEOUT))));
	}


	/**
	 *
	 * @param to Katalon TestObject
	 * @param timeout int
	 * @return
	 */
	@Keyword
	def checkAndTapButtonIfPresent(TestObject to, int timeout) {
		if(Mobile.waitForElementPresent(to, timeout)) {
			try {
				if( Mobile.waitForElementPresent(to, timeout)) {
					Mobile.tap(to, WAIT_TIMEOUT);
				} else{
					refreshScreen(to);
					Mobile.tap(to, WAIT_TIMEOUT);
				}
			} catch (StaleElementReferenceException e) {
				refreshScreen(to);
				Mobile.tap(to, WAIT_TIMEOUT);
			}
		}
		KeywordUtil.logInfo("No skip button because Onboarding is not displayed ");
	}


	/**
	 * Get mobile driver for current session
	 * @return mobile driver for current session
	 */
	@Keyword
	def WebDriver getCurrentSessionMobileDriver() {
		return MobileDriverFactory.getDriver();
	}

	@Keyword
	public void openAppWith(String url, String bundleId) {

		AppiumDriver<?> driver = MobileDriverFactory.getDriver();

		try {
			By urlBtn = MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeOther' && name CONTAINS 'CapsuleNavigationBar'");
			By urlFld = MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeTextField' && name CONTAINS 'URL'");
			By openBtn = MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' && name CONTAINS 'Open'");
			driver.activateApp("com.apple.mobilesafari");
			//WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(urlBtn)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(urlFld)).sendKeys("" + url + "\uE007");
			wait.until(ExpectedConditions.visibilityOfElementLocated(openBtn)).click();
		} catch (Exception e) {
			KeywordUtil.markErrorAndStop("Error " + e.toString() );
		}


	}
}