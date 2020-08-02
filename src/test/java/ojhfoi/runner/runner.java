package ojhfoi.runner;

import com.codeborne.selenide.testng.SoftAsserts;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import listener.testListener;
import org.testng.annotations.Listeners;

@CucumberOptions(
        features = "src/test/resources",
        glue = {"ojhfoi.stepdefinition", "ojhfoi.navigate", "ojhfoi.tears"},
        tags = "",
        plugin = {"pretty"}
)
@Listeners({testListener.class, SoftAsserts.class})
public class runner extends AbstractTestNGCucumberTests {

}
