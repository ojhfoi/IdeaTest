import com.codeborne.selenide.testng.SoftAsserts;
import com.codeborne.selenide.webdriver.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.testng.AllureTestNg;
import listener.testListener;
import org.openqa.selenium.WebDriver;
import org.testng.ITestNGListener;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

@Listeners({SoftAsserts.class, testListener.class, AllureTestNg.class})
public class BrowserConfig extends WebDriverFactory {

    private static WebDriver driver = null;    

    @Before
    public void CreateDriver(){
//        String br = System.getProperty("browser").toUpperCase();
//        if (br == null){
//            br = "CHROME";
//        }
        String br = "CHROME";
        setWebDriver(browser.valueOf(br).create());
    }

    @After
    public void CloseDriver() {
        if (getWebDriver() != null) {
            getWebDriver().quit();
        }
    }

}
