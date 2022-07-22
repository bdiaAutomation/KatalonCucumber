package hooks
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.junit.BeforeClass
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileAbstractKeyword
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

import io.appium.java_client.AppiumDriver
import javassist.bytecode.stackmap.BasicBlock.Catch
import pom.Onboarding_Start_App
import pom.Page_Home
import pom.Page_Start
import cucumber.api.java.After
import cucumber.api.java.Before
import cucumber.api.Scenario



class GlobalHooks {


	@Before(order = 0)
	public void setUp( Scenario scenario) {
		KeywordUtil.logInfo("*************** Start Scenario ***************");
		KeywordUtil.logInfo("***************" +  scenario.getName() + "*************** ");

		//AppiumDriver<?> driver = MobileDriverFactory.getDriver();
		//driver.launchApp();
		Mobile.comment("Starting appium server and install app");
		KeywordUtil.logInfo("Starting appium server and install app");
		try {
			RunConfiguration.setMobileDriverPreferencesProperty("locale", GlobalVariable.locale);
			RunConfiguration.setMobileDriverPreferencesProperty("language", GlobalVariable.language);
			RunConfiguration.setMobileDriverPreferencesProperty("wdaLocalPort", GlobalVariable.wdaLocalPort);
			RunConfiguration.setMobileDriverPreferencesProperty("useNativeCachingStrategy", GlobalVariable.useNativeCachingStrategy);
			Mobile.startApplication("/Users/bambadia/Desktop/APK/smi_140.app", true, FailureHandling.STOP_ON_FAILURE);

		}catch(Exception e){
			KeywordUtil.markErrorAndStop("Unable to install app")
		}

	}

	@Before(order = 1)
	public void passedOnboardingStepsAndGoToHomePage() {

		try {

			KeywordUtil.logInfo("*************** Processing Onboarding steps ***************");
			def page_Start = new Page_Start();
			page_Start.clickOnContinueBtn()
					.allowTracking()
					.refuseAllcookies();
			def onboarding_Start_App = new Onboarding_Start_App();
			onboarding_Start_App.clickSkipBtn();
			onboarding_Start_App.clickSkipBtn();
			onboarding_Start_App.clickSkipBtn();
			
			Mobile.verifyEqual((new Page_Home()).is_HeaderLogo_Present(), true);

		} catch (Exception e) {
			KeywordUtil.markErrorAndStop("Cannot process onboarding steps");
			e.printStackTrace()
		}

	}

	@After
	public void tearDown(Scenario scenario) {
		KeywordUtil.logInfo("*************** End Scenario *************** ");
		KeywordUtil.logInfo("***************" +  scenario.getName() + "*************** ");
		KeywordUtil.logInfo("Closing app and STOPING appium server");
		Mobile.closeApplication(FailureHandling.STOP_ON_FAILURE)
	}
}