package ojhfoi.tears;

import com.codeborne.selenide.testng.SoftAsserts;
import com.codeborne.selenide.webdriver.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import listener.testListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

@Listeners({SoftAsserts.class, testListener.class})
public class BrowserConfig extends WebDriverFactory {

    private static WebDriver driver = null;    

    @Before
    public void CreateDriver(){
//        String br = System.getProperty("ojhfoi.tears.browser").toUpperCase();
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
