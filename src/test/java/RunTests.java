import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/resources/features/apiusercontroller",
                "src/test/resources/features/swaglabs"
        },
        glue = {
                "apiusercontroller/stepdefs",
                "swaglabs/cucumber/stepdefs"
        },
        plugin = {
                "pretty", 
                "html:target/testReport.html", 
                "json:target/jsonReport.json"
        }
)
public class RunTests {
}
