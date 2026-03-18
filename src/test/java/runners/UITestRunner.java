package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/UI",
        glue = "steps",
        dryRun = false,
        tags = "@login",
        plugin = {"pretty", "html:target/ui-cucumber.html", "json:target/ui-cucumber.json", "rerun:target/ui-failed.txt"}
)

public class UITestRunner {
}
