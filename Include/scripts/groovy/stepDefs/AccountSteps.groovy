package stepDefs
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
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import groovy.ui.SystemOutputInterceptor
import groovy.util.logging.Log



class AccountSteps {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("I am connected")
	public void i_am_connected() {
		// Write code here that turns the phrase above into concrete actions
		KeywordUtil.logInfo("first step : I am connected");
	}

	@Given("I am in account screen")
	public void i_am_in_account_screen() {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("I clicked the settings entry")
	public void i_clicked_the_settings_entry() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("I am rediret to seetings app")
	public void i_am_rediret_to_seetings_app() {
		// Write code here that turns the phrase above into concrete actions
		KeywordUtil.logInfo("Last step ")
	}

	@When("I switch to another {string}")
	public void i_switch_to_another(String string) {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("I see the entry lang  {string}")
	public void i_see_the_entry_lang(String string) {
		// Write code here that turns the phrase above into concrete actions
		KeywordUtil.logInfo("Last step ")
	}

	@When("I clicked the cookies preferences entry")
	public void i_clicked_the_cookies_preferences_entry() {
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("I see cookies screen")
	public void i_see_cookies_screen() {
		// Write code here that turns the phrase above into concrete actions
		KeywordUtil.logInfo("Last step ")
	}
}