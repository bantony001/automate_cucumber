package com.amazon.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * Hello world!
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features",
		glue= {"com.amazon.stepDefs"}
		)
public class CucumberTest 
{
}


