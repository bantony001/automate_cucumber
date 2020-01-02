package com.amazon.testrunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.amazon.manager.FileReaderManager;
//import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * Hello world!
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features",
		glue= {"com.amazon.stepDefs"},
		//plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter::target/cucumber-reports/report.html"},
		monochrome = true
		)
public class CucumberTest 
{
	 @AfterClass
	 public static void writeExtentReport() {
	 //Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
	 }
}


