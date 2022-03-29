package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //plugin = {""},
        features = {"src/test/resources/Features"},
        glue = {"stepDef"},
        tags = "@salesman",
        dryRun = false
)
public class CukesRunner {
}
