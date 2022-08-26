package pom

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.security.PrivateKey

import org.openqa.selenium.By
import org.openqa.selenium.By.ById
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileAbstractKeyword
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.MobileTestObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import groovy.inspect.swingui.BytecodeCollector

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper

import internal.GlobalVariable
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileBy
import utils.MobileHelper

public class Page_Login extends MobileHelper {

	private TestObject webViewEmailField = findTestObject("Object Repository/MobileUI/Component/Login/Input_webviewEmailTxtField");


	private By webViewPwdlField = By.name("passwordLogin");
	private By webViewSignInBtn = By.id("btnSubmit_login");
	private MobileBy keyboardNextBtn = MobileBy.AccessibilityId("Next:");
	private MobileBy keyboardDoneBtn = MobileBy.AccessibilityId("Done")

	private MobileTestObject forgottenPasswordButtonId = findTestObject('Object Repository/MobileUI/Component/Login/Link_forgottenPasswordButtonId');
	private MobileTestObject pwdTxtField = findTestObject('Object Repository/MobileUI/Component/Login/Input_pwdTxtField');
	private MobileTestObject emailTxtField = findTestObject('Object Repository/MobileUI/Component/Login/Input_emailTxtField');
	private MobileTestObject signInBtn = findTestObject('Object Repository/MobileUI/Component/Login/Button_signUpButtonId');
	private MobileTestObject signUpBtn = findTestObject('Object Repository/MobileUI/Component/Login/Button_signInButtonId');
	private MobileTestObject closeLoginPage = findTestObject('Object Repository/MobileUI/Component/Login/Button_closeWebview');

	@Keyword
	public void loginWithEmailAndPassword(String email, String pwd) {
		Thread.sleep(3000);
		// TODO refactor wait using Thread.sleep
		Set<String> contexts = MobileDriverFactory.getDriver().getContextHandles();
		KeywordUtil.logInfo("AAAAAAAAAAAAAAAAAAAAAAA " + contexts.size());
		//KeywordUtil.logInfo(MobileDriverFactory.getDriver().getContextHandles());
		String exceutionProfile = RunConfiguration.getExecutionProfile();
		KeywordUtil.logInfo("VOICIIIIIIIIIIIIIIIIIIIII LE PROFIL :  " + exceutionProfile);

		if (exceutionProfile.equalsIgnoreCase("ES")) {
			AppiumDriver<?> driver =  MobileDriverFactory.getDriver();
			driver.context((String) contexts.toArray()[contexts.size() - 1]);
			//Mobile.switchToWebView();
			KeywordUtil.logInfo(MobileDriverFactory.getDriver().getContext());
			//Mobile.setText(webViewEmailField, email, WAIT_TIMEOUT);
			WebElement elt = driver.findElement(By.xpath("//input[@id='uname1']"));
			elt.sendKeys(email);
			KeywordUtil.logInfo("Enter email : " + email );
			driver.findElement(By.xpath("//input[@name='passwordLogin']")).sendKeys(pwd);
			KeywordUtil.logInfo("Enter password : " + pwd );
			KeywordUtil.logInfo("Tap on  SignIn button");
			driver.findElement(By.xpath("//input[@id='btnSubmit_login']")).click();

			KeywordUtil.logInfo("THIS IS THE CONTEXT BEFORE SWITCHING " + MobileDriverFactory.getDriver().getContext());

			//driver.context((String) contexts.toArray()[0]);
			Mobile.switchToNative(FailureHandling.STOP_ON_FAILURE);

			closeLoginPage();

			KeywordUtil.logInfo("THIS IS THE ACTUAL CONTEXT " + MobileDriverFactory.getDriver().getContext());

			Thread.sleep(5000);
		} else {
			waitForVisibilityOfElement(signInBtn);
			Mobile.sendKeys(emailTxtField, email);
			KeywordUtil.logInfo("Enter email : " + email );
			Mobile.tap(keyboardNextBtn, WAIT_TIMEOUT);
			Mobile.sendKeys(pwdTxtField, pwd);
			KeywordUtil.logInfo("Enter password : " + pwd );
			Mobile.tap(keyboardDoneBtn, WAIT_TIMEOUT);
			KeywordUtil.logInfo("Tap on  SignIn button");
			Mobile.tap(signInBtn, WAIT_TIMEOUT);
		}
	}

	@Keyword
	def closeLoginPage() {
		tap(closeLoginPage);
	}
}
