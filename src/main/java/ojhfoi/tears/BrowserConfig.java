package ojhfoi.tears;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.webdriver.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

@Component()
public class BrowserConfig extends WebDriverFactory {

    private static WebDriver driver = null;    

//    @BeforeSuite
    @Autowired
    @Scope("singleton")
    public void CreateDriver() throws MalformedURLException {
        String br = System.getProperty("browser");
        if (br == null){
            br = "firefox";
        }
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setPlatform(Platform.LINUX);
//        capabilities.setBrowserName(br);
        switch(br){
            case "chrome":
                DesiredCapabilities capabilities = new DesiredCapabilities().chrome();
                capabilities.setPlatform(Platform.LINUX);
                driver = new RemoteWebDriver(new URL("http://localhost:5558/wd/hub"), capabilities);
                break;
            case "firefox":
                DesiredCapabilities capabilitiesfox = new DesiredCapabilities().firefox();
                capabilitiesfox.setPlatform(Platform.LINUX);

                driver = new RemoteWebDriver(new URL("http://localhost:5556/wd/hub"), capabilitiesfox);
                break;
            default:
                System.out.println("Not environment for browser! Test not running");
        }
//        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
        WebDriverRunner.setWebDriver(driver);
//        String br = "CHROME";
//        setWebDriver(browser.CHROME.create());
    }

    @Bean
    @AfterTest
    public void CloseDriver() {
        if (getWebDriver() != null) {
            getWebDriver().quit();
        }
    }


}
