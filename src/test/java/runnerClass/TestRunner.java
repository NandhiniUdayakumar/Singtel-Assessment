package runnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

@RunWith(io.cucumber.junit.Cucumber.class)
@CucumberOptions(features = "Features"
,glue={"stepDefinition"},
plugin = { "pretty",
		"html:target/cucumber.html","junit:target/cucumber.xml"},
monochrome = true
)
public class TestRunner {

}
