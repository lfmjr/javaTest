package suporte;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Luiz Fernando\\git\\javaTest\\cucumber\\features",
	glue = { "" }, monochrome = true, dryRun = false)
public class cucumberTest {
}