package ojhfoi.navigate;

import Allert.AllertWind;
import io.cucumber.java.en.Given;
import ojhfoi.navigate.config.config;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class OpenSite {


    @Given("Open site")
    @Test(description = "Переходим на сайт")
    public void OpenSite() throws Throwable{
        try {

            WebDriver driver = getWebDriver();

            config cfg = ConfigFactory.create(config.class);

            driver.navigate().to("http://tsum.ru");

            AllertWind.AlertAccept();

        } catch (Throwable throwable) {
            Assert.assertTrue(false, "Can't open site becouse: \n" + throwable.getCause());
            throwable.printStackTrace();
        }

    }

}
