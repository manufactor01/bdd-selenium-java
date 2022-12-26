package utils;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "classpath:stepDefinitions",
        tags = {"@LogInPlayground"},
        monochrome = true,
        strict = true
)
public class TestRunner {
}
