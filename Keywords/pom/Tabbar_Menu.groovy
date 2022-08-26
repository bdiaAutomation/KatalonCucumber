package pom

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.security.PrivateKey
import java.security.PublicKey

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.MobileTestObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import utils.MobileHelper

public class Tabbar_Menu extends MobileHelper {

	private MobileTestObject accountIconBtn = findTestObject('Object Repository/MobileUI/Component/TabbarMenu/Button_accountIcon');
	private MobileTestObject cartIconBtn  = findTestObject('Object Repository/MobileUI/Component/TabbarMenu/Button_cartIcon');
	private MobileTestObject homeIconBtn = findTestObject('Object Repository/MobileUI/Component/TabbarMenu/Button_homeIcon');
	private MobileTestObject mcommerceIconBtn = findTestObject('Object Repository/MobileUI/Component/TabbarMenu/Button_mcommerceIcon');
	private MobileTestObject promotionsIconBtn = findTestObject('Object Repository/MobileUI/Component/TabbarMenu/Button_promotionsIcon');

	@Keyword
	public Page_Home clickOnAccountEntry() {
		Mobile.tap(accountIconBtn, WAIT_TIMEOUT);
		return new Page_Home();
	}


	@Keyword
	public void  clickOnHomeEntry() {
		Mobile.tap(homeIconBtn, WAIT_TIMEOUT);
	}

	@Keyword
	public void  clickOnMcommerceEntry() {
		Mobile.tap(mcommerceIconBtn, WAIT_TIMEOUT);
	}

	@Keyword
	public void  clickOnCuponEntry() {
		Mobile.tap(promotionsIconBtn, WAIT_TIMEOUT);
	}

	@Keyword
	public void  clickOnCartEntry() {
		Mobile.tap(cartIconBtn, WAIT_TIMEOUT);
	}
}
