package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = "Odev1.stepDefinitions",
        plugin = {"pretty",
                "html:target/cucumber-report/cucumber.html", "timeline:target/cucumber-report/"}
        , dryRun = false
)
public class TestRunner {
}
