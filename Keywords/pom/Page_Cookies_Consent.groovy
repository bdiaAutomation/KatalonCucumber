package pom

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

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
import utils.MobileHelper

public class Page_Cookies_Consent {

	MobileHelper utils = new MobileHelper();

	private TestObject refuseAllcookiesBtn = findTestObject('Object Repository/MobileUI/Pages/Page_Cookies_Consent/Button_refuseAllCookies');
	private TestObject acceptAllCookiesBtn = findTestObject('Object Repository/MobileUI/Pages/Page_Cookies_Consent/Button_acceptAllCookies');
	private TestObject  cookiesSettingsLink = findTestObject('Object Repository/MobileUI/Pages/Page_Cookies_Consent/Link_cookiesSettings');
	private TestObject cookiesPageDescTxt = findTestObject('Object Repository/MobileUI/Pages/Page_Cookies_Consent/Txt_cookiesPageDesc');
	private TestObject cookiesPageTitleTxt = findTestObject('Object Repository/MobileUI/Pages/Page_Cookies_Consent/Txt_cookiesPageTitle');

	@Keyword
	def refuseAllcookies() {
		Mobile.tap(refuseAllcookiesBtn, utils.WAIT_TIMEOUT);
	}

	@Keyword
	def acceptAllCookies() {
		Mobile.tap(acceptAllCookiesBtn, utils.WAIT_TIMEOUT);
	}

	@Keyword
	def setCookies() {
		Mobile.tap(cookiesSettingsLink, utils.WAIT_TIMEOUT);
	}
}