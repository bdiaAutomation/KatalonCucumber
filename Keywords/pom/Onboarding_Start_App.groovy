package pom

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject


import org.openqa.selenium.StaleElementReferenceException

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileAbstractKeyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.MobileTestObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.sun.org.apache.bcel.internal.generic.RETURN

import groovy.swing.impl.DefaultAction
import internal.GlobalVariable
import utils.MobileHelper

public class Onboarding_Start_App extends MobileHelper {

	//MobileHelper utils = new MobileHelper();

	private MobileTestObject  actionBtn = findTestObject('Object Repository/MobileUI/Component/Onboarding_Start_App/Button_loginButtonId');

	private MobileTestObject pagination = findTestObject('Object Repository/MobileUI/Component/Onboarding_Start_App/Button_pagination');

	private MobileTestObject skipBtn = findTestObject('Object Repository/MobileUI/Component/Onboarding_Start_App/Button_skipButtonId');

	private MobileTestObject descTxt = findTestObject('Object Repository/MobileUI/Component/Onboarding_Start_App/Txt_description');

	private MobileTestObject titleTxt = findTestObject('Object Repository/MobileUI/Component/Onboarding_Start_App/Txt_title');

	private MobileTestObject loginOnboardingImg = findTestObject('Object Repository/MobileUI/Component/Onboarding_Start_App/Image_loginOnboarding');

	private MobileTestObject notificationOnboardingImg = findTestObject('Object Repository/MobileUI/Component/Onboarding_Start_App/Image_notificationOnboarding');

	private MobileTestObject pickAstoreOnboardingImg = findTestObject('Object Repository/MobileUI/Component/Onboarding_Start_App/Image_notificationOnboarding');

	@Keyword
	def clickSkipBtn() {
		checkAndTapSkipButtonIfPresent(skipBtn, 2)
	}



	@Keyword
	def loginBtn() {
		Mobile.tap(actionBtn, WAIT_TIMEOUT);
	}



	@Keyword
	public boolean isOnboardingDisplayed(int timeout) {
		return ((Mobile.waitForElementPresent(loginOnboardingImg, timeout)) || (Mobile.waitForElementPresent(pickAstoreOnboardingImg, timeout)) || (Mobile.waitForElementPresent(notificationOnboardingImg, timeout)));
	}


	@Keyword
	def notificationBtn() {
		Mobile.tap(actionBtn, WAIT_TIMEOUT);
	}

	@Keyword
	def chooseAstoreBtn() {
		Mobile.tap(actionBtn, WAIT_TIMEOUT);
	}

	/**
	 *
	 * @param to Katalon TestObject
	 * @param timeout int
	 * @return
	 */
	@Keyword
	def checkAndTapSkipButtonIfPresent(TestObject to, int timeout) {
		if(isOnboardingDisplayed(timeout)) {
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
}