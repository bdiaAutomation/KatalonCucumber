package pom

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.security.PrivateKey

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.builtin.TapKeyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import utils.MobileHelper

public class Page_Start {

	/**
	 * Start page
	 * MobileUI Objects 
	 */
	private TestObject logoBirdy =  findTestObject('Object Repository/MobileUI/Pages/Page_Start/Image_logoBirdy');
	private TestObject suggestedContinueBtn = findTestObject('Object Repository/MobileUI/Pages/Page_Start/Button_suggestedContinueBtn');
	private TestObject suggestedChangeCountry = findTestObject('Object Repository/MobileUI/Pages/Page_Start/Button_suggestedChangeCountry');


	@Keyword
	def Page_One_Trust clickOnContinueBtn() {
		Mobile.tap(suggestedContinueBtn, MobileHelper.WAIT_TIMEOUT);
		return new Page_One_Trust();
	}

	@Keyword
	def clickOnSelectACountryBtn() {
		Mobile.tap(suggestedChangeCountry, MobileHelper.WAIT_TIMEOUT);
	}
}
