package ojhfoi.runner;

import cucumber.api.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;
import ojhfoi.JpaConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = JpaConfig.class)
@ContextConfiguration(classes = runner.class, loader = SpringBootContextLoader.class)
public class CucumberSpringContextConfiguration{

    public static void main(String[] args){
        ConfigurableApplicationContext context =
                SpringApplication.run(runner.class, args);
        context.getEnvironment().addActiveProfile("cucum");

    }

}
