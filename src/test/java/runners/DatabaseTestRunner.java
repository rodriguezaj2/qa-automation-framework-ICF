package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/DatabaseTesting",
        glue = "steps",
        dryRun = false,
        tags = "@DBValidation",
        plugin = {"pretty", "html:target/db-cucumber.html", "json:target/db-cucumber.json", "rerun:target/db-failed.txt"}
)

public class DatabaseTestRunner {
}
