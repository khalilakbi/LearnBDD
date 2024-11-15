package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {".\\src\\test\\resources"}, // the features path
        glue = {"steps_definitions"}  //  steps definitions package
)

public class TestRunner {
}
