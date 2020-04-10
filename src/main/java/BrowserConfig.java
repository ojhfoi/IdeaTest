import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static org.openqa.selenium.PageLoadStrategy.NORMAL;

public class BrowserConfig {

    private static WebDriver driver = null;

    @Test
    public void InitalBrowser() {
        String browser = System.getProperty("browser.name");
        switch (browser){
            case "chrome":
                ChromeOptions co = new ChromeOptions();
                co.setPageLoadStrategy(NORMAL);
                co.addArguments("--incognito", "--window-size=1024,768");
                driver = new ChromeDriver(co);
                break;

            case "firefox":
                FirefoxOptions fo = new FirefoxOptions();
                fo.setPageLoadStrategy(NORMAL);
                fo.addArguments("--private", "--window-size=1024,768");
                driver = new FirefoxDriver(fo);
                break;
        }

        setWebDriver(driver);

    }

}
