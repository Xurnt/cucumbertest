package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
features="src/test/java/features",
glue="StepDefinitions",
tags= "@AuthentificationTest",
plugin = { "pretty", "json:target/json/authentificationResult.json" },
monochrome = true)

public class AuthentificationRunner {

}
