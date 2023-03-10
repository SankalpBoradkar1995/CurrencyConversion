package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/Features",
glue="StepDefinition",
plugin = { "pretty","html:src/test/resources/Reports/index.html" },
monochrome = true)
public class TestNgRunner extends AbstractTestNGCucumberTests{

}
