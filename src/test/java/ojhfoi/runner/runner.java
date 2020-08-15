package ojhfoi.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


@CucumberOptions(
        features = "src/test/resources",
        glue = {"ojhfoi.stepdefinition", "ojhfoi.navigate", "ojhfoi.tears"},
        tags = "@tsum_gift",
        plugin = {"pretty", "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"},
        monochrome = true
)
@ContextConfiguration("classpath: context.xml")
@SpringBootTest
//@Listeners({testListener.class, SoftAsserts.class})
public class runner extends AbstractTestNGCucumberTests{

}