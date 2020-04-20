import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;


public class BrowserConfig {

    private static WebDriver driver = null;    

    @BeforeSuite
    public void CreateDriver(){
        String br = System.getProperty("browser").toUpperCase();
        setWebDriver(browser.valueOf(br).create());

    }

    @AfterSuite(description = "Close browser and driver")
    public void CloseDriver() {
        if (getWebDriver() != null) {
            getWebDriver().quit();
        }
    }

}
