package org.testRunner;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		features ="@target/Failed_Scenarios.txt",
		glue = {"org.stepdefinitions","org.applicationhooks"},
		monochrome = true, 
		dryRun = false ,
		plugin = {"pretty",
				"html:target/html_report/cucumber_report.html",
				"json:target/json_report/json_report.json",
				"junit:target/junit_report/junit_report.xml",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				//"rerun:target/Failed_Scenarios.txt" // Generate a file containing failed scenarios information
		}
)

public class ReRunnerTest  extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}