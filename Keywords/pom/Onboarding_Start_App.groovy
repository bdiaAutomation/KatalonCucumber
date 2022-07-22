package pom

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.security.PrivateKey

import org.openqa.selenium.StaleElementReferenceException

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

public class Onboarding_Start_App {

	TestUtils utils = new TestUtils();

	private TestObject  actionBtn = findTestObject('Object Repository/MobileUI/Component/Onboarding_Start_App/Button_loginButtonId');

	private TestObject pagination = findTestObject('Object Repository/MobileUI/Component/Onboarding_Start_App/Button_pagination');

	private TestObject skipBtn = findTestObject('Object Repository/MobileUI/Component/Onboarding_Start_App/Button_skipButtonId');

	private TestObject descTxt = findTestObject('Object Repository/MobileUI/Component/Onboarding_Start_App/Txt_description');

	private TestObject titleTxt = findTestObject('Object Repository/MobileUI/Component/Onboarding_Start_App/Txt_title');


	@Keyword
	def clickSkipBtn() {

		try {
			if( utils.isElementPresent_Error_Not_Throw(skipBtn, utils.WAIT_TIMEOUT)) {
				Mobile.tap(skipBtn, utils.WAIT_TIMEOUT);
			} else{
				utils.refreshScreen(skipBtn);
				Mobile.tap(skipBtn, utils.WAIT_TIMEOUT);
			}
			
			
		} catch (StaleElementReferenceException e) {
			utils.refreshScreen(skipBtn);
			Mobile.tap(skipBtn, utils.WAIT_TIMEOUT);
		}
	}

	@Keyword
	def loginBtn() {
		Mobile.tap(actionBtn, utils.WAIT_TIMEOUT);
	}


	@Keyword
	def notificationBtn() {
		Mobile.tap(actionBtn, utils.WAIT_TIMEOUT);
	}

	@Keyword
	def chooseAstoreBtn() {
		Mobile.tap(actionBtn, utils.WAIT_TIMEOUT);
	}
}