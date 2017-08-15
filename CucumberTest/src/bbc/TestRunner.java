/*
 * This class is used as starting point to invoke Cucumber BDD Framework
 */
package bbc;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

// TODO: Auto-generated Javadoc
/**
 * The Class TestRunner.
 */

// Defines that this test would be run as Cucumber and not plain jUnit
@RunWith(Cucumber.class)

/*
 * Specify Cucumber Options
 * 
 * features scans the specified location for .feature files
 * 
 * glue option connects step definition file with runner as Cucumber test
 */
@CucumberOptions(features = "Feature", glue = { "stepDefinition" }, plugin = { "pretty", "html:d:/java" })

public class TestRunner {

	/**
	 * Instantiates a new test runner.
	 */
	public TestRunner() {
		// Purposely kept empty
	}

}
