package runner;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "", features = "Include/features", plugin = { "pretty", "html:Reports/cucumber-reports" }, tags = "@LU" )
public class LuRunner {

}