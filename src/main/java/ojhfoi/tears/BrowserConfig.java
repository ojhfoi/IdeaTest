package ojhfoi.tears;

import com.codeborne.selenide.webdriver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

@Component()
public class BrowserConfig extends WebDriverFactory {

    private static WebDriver driver = null;    

//    @BeforeSuite
    @Autowired
    @Scope("singleton")
    public void CreateDriver(){
//        String br = System.getProperty("browser").toUpperCase();
//        if (br == null){
//            br = "CHROME";
//        }
        String br = "CHROME";
        setWebDriver(browser.CHROME.create());
    }

    @Bean
    @AfterTest
    public void CloseDriver() {
        if (getWebDriver() != null) {
            getWebDriver().quit();
        }
    }


}
