package km.steps;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by KrishnaMohan on 26/12/2016.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        tags = {"@km"},
        format = {"pretty", "html:target/reports/html", "json:target/reports/cucumber.json", "junit:target/reports/cucumber.xml"}
)

public class RunTests {

}
