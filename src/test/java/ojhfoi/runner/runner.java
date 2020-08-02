package ojhfoi.runner;

import com.codeborne.selenide.testng.SoftAsserts;
import cucumber.runtime.model.CucumberFeature;
import gherkin.events.PickleEvent;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import listener.testListener;
import org.testng.annotations.*;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = {"ojhfoi.stepdefinition", "ojhfoi.navigate", "ojhfoi.tears"},
        tags = "",
        plugin = {"pretty", "json:result/report/report.json"}
)
@Listeners({testListener.class, SoftAsserts.class})
public class runner extends AbstractTestNGCucumberTests {

}
