package ojhfoi.runner;

import com.codeborne.selenide.testng.SoftAsserts;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.qameta.allure.testng.AllureTestNg;
import listener.testListener;
import org.junit.runner.RunWith;
import org.testng.annotations.Listeners;

import java.io.IOException;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = {"src/test/java/ojhfoi", "src/main/java"},
        tags = "@all",
        plugin = {"pretty"}
)
@Listeners({testListener.class, AllureTestNg.class, SoftAsserts.class})
public class runner extends AbstractTestNGCucumberTests {

}
