package pom

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.github.fge.jsonschema.examples.Utils
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileAbstractKeyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import utils.TestUtils

public class Page_Home {

	TestUtils utils =  new TestUtils();

	private TestObject headerWelcomeNameTxt = findTestObject('Object Repository/MobileUI/Pages/Page_Home/Text_header_welcomeName');
	private TestObject headerSecondLineTxt = findTestObject('Object Repository/MobileUI/Pages/Page_Home/Text_header_secondLine');
	private TestObject headerSearchInput  = findTestObject('Object Repository/MobileUI/Pages/Page_Home/Input_header_search_edittext');
	private TestObject headerAuchanLogo = findTestObject('Object Repository/MobileUI/Pages/Page_Home/Image_header_auchanLogo');
	private TestObject headerLoyaltyBtn = findTestObject('Object Repository/MobileUI/Pages/Page_Home/Button_header_loyaltyVisual');
	private TestObject chooseAstoreBtn = findTestObject('Object Repository/MobileUI/Pages/Page_Home/Button_widget_chooseAstore');



	@Keyword
	public String getHeaderWelcomeNameTxt() {
		return Mobile.getAttribute(headerWelcomeNameTxt, "label", utils.WAIT_TIMEOUT);
	}

	@Keyword
	public Boolean is_HeaderLogo_Present() {
		return utils.isElementPresent_Mobile(headerAuchanLogo, utils.WAIT_TIMEOUT);
	}


	@Keyword
	public String getHeaderSecondLineTxt() {
		return Mobile.getAttribute(headerSecondLineTxt, "label", utils.WAIT_TIMEOUT);
	}


	@Keyword
	public void clickOnHeaderSearchInput() {
		Mobile.tap(headerSearchInput, utils.WAIT_TIMEOUT);
	}


	@Keyword
	public void longPressOnHeaderAuchanLogo() {
		Mobile.tapAndHold(headerAuchanLogo, 10, utils.WAIT_TIMEOUT);
	}


	public void clickOnHeaderLoyaltyBtn() {

		Mobile.tap(headerLoyaltyBtn, utils.WAIT_TIMEOUT);
	}
}
