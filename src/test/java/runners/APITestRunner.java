package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/API",
        glue = "steps",
        dryRun = false,
        tags = "@getRecord",
        plugin = {"pretty", "html:target/api-cucumber.html", "json:target/api-cucumber.json", "rerun:target/api-failed.txt"}
)
public class APITestRunner {

}
