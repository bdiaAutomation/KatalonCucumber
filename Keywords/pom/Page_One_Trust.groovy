package pom

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.security.PublicKey

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import utils.TestUtils

public class Page_One_Trust {

	TestUtils utils = new TestUtils();

	private TestObject continueButtonId = findTestObject('Object Repository/MobileUI/Pages/Page_One_Trust/Button_continueButtonId');
	private TestObject oneTrustImg = findTestObject('Object Repository/MobileUI/Pages/Page_One_Trust/Image_friendlyTracking') ;
	private TestObject oneTrustDesc = findTestObject('Object Repository/MobileUI/Pages/Page_One_Trust/Text_descriptionLabelId') ;
	private TestObject oneTrustTitle = findTestObject('Object Repository/MobileUI/Pages/Page_One_Trust/Text_titleLabelId');
	private TestObject alertAllowTrackingBtn = findTestObject('Object Repository/MobileUI/Pages/Page_One_Trust/Button_allow') ;
	private TestObject alertDeclineTrackingBtn =  findTestObject('Object Repository/MobileUI/Pages/Page_One_Trust/Button_ask_App_Not_to_Track') ;


	/**
	 * 
	 * @return
	 */
	@Keyword
	public Page_Cookies_Consent allowTracking() {
		clickOnContinueBtn();
		clickOnAllowAlertBtn();		
		return new Page_Cookies_Consent();
	}

	@Keyword
	def clickOnContinueBtn() {
		Mobile.tap(continueButtonId, TestUtils.WAIT_TIMEOUT);
	}

	@Keyword
	def clickOnAllowAlertBtn() {
		utils.waitForVisibilityOfElement(alertAllowTrackingBtn);
		Mobile.tap(alertAllowTrackingBtn, utils.WAIT_TIMEOUT);
	}
}




