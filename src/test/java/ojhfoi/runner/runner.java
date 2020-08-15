package ojhfoi.runner;

import com.codeborne.selenide.testng.SoftAsserts;
import cucumber.api.junit.Cucumber;
import io.cucumber.spring.CucumberContextConfiguration;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import listener.testListener;
import ojhfoi.JpaConfig;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Listeners;


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