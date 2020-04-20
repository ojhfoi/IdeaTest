import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public enum browser {
    CHROME{
        @Override
        public WebDriver create(){
            WebDriverManager.chromedriver().setup();
            ChromeOptions ch = new ChromeOptions();
            ch.addArguments("--incognito", "--window-size=1024,768");
            return new ChromeDriver(ch);
        }
    },
    FIREFOX{
        @Override
        public WebDriver create(){
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions fo = new FirefoxOptions();
            fo.addArguments("--private", "--window-size=1024,768");
            return new FirefoxDriver(fo);
        }
    };

    public WebDriver create(){
        return null;
    }
}
