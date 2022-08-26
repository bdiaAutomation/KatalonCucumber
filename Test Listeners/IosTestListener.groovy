import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext



// DELETE IT AFTER

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.util.KeywordUtil
import io.appium.java_client.AppiumDriver
import pom.Onboarding_Start_App
import pom.Page_Home
import pom.Page_Start
import cucumber.api.java.After
import cucumber.api.java.Before
import groovy.ui.SystemOutputInterceptor
import cucumber.api.Scenario


class IosTestListener {
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
	@BeforeTestCase
	def startApp(TestCaseContext testCaseContext) {

		Mobile.comment("Starting appium server and install app");
		KeywordUtil.logInfo("Starting appium server and install app");
		try {
			RunConfiguration.setMobileDriverPreferencesProperty("locale", GlobalVariable.locale);
			RunConfiguration.setMobileDriverPreferencesProperty("language", GlobalVariable.language);
			RunConfiguration.setMobileDriverPreferencesProperty("wdaLocalPort", GlobalVariable.wdaLocalPort);
			RunConfiguration.setMobileDriverPreferencesProperty("useNativeCachingStrategy", GlobalVariable.useNativeCachingStrategy);
			RunConfiguration.setMobileDriverPreferencesProperty("webkiDebugProxyPort", 27753);
			RunConfiguration.setMobileDriverPreferencesProperty("includeSafariInWebviews", true);
			RunConfiguration.setMobileDriverPreferencesProperty("webviewConnectTimeout", 5000);
			RunConfiguration.setMobileDriverPreferencesProperty("browserName", "Safari");
			RunConfiguration.setMobileDriverPreferencesProperty("newWDA", GlobalVariable.newWDA);
			RunConfiguration.setMobileDriverPreferencesProperty("startIWDP", true);
			// TODO parametrize app file
			Mobile.startApplication("/Users/bambadia/Desktop/APK/smi.app", true, FailureHandling.STOP_ON_FAILURE);

		}catch(Exception e){
			KeywordUtil.markErrorAndStop("Unable to install app")
		}

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
}