package ebay.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/java/ebay/features",
        glue = "ebay.steps"
)
public class RunnerCucumberTests extends AbstractTestNGCucumberTests{
}
