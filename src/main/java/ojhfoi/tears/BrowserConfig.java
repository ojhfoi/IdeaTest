import com.codeborne.selenide.webdriver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;


public class BrowserConfig extends WebDriverFactory {

    private static WebDriver driver = null;    

    @Test
    public void CreateDriver(){
//        String br = System.getProperty("browser").toUpperCase();
//        if (br == null){
//            br = "CHROME";
//        }
        String br = "CHROME";
        setWebDriver(browser.CHROME.create());
    }

    @AfterSuite(description = "Close browser and driver")
    public void CloseDriver() {
        if (getWebDriver() != null) {
            getWebDriver().quit();
        }
    }

}
