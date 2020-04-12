package ojhfoi.navigate;

import ojhfoi.navigate.config.config;
import org.aeonbits.owner.ConfigFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class OpenSite {

    @Test(description = "run site")
    public void OpenSite() throws Throwable{
        try {

            config cfg = ConfigFactory.create(config.class);

            getWebDriver().navigate().to(cfg.hostname());
            System.out.println("Site is open! Site title:" + getWebDriver().getTitle());

        } catch (Throwable throwable) {
            Assert.assertTrue(false, "Can't open site becouse: \n" + throwable.getCause());
            throwable.printStackTrace();
        }

    }

}
