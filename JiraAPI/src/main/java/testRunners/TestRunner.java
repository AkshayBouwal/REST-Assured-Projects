package testRunners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(

        features = {"src/main/java/features/Jira.feature"},
        glue = {"stepDefinitions"},
        plugin = {
                "pretty",
                "json:src/main/java/reports/cucumber.json",
                "html:src/main/java/reports/cucumber.html",
        }

)

public class TestRunner {


}


