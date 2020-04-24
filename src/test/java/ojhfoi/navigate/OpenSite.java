package ojhfoi.navigate;

import ojhfoi.navigate.config.config;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class OpenSite {



    @Test(description = "run site")
    public void OpenSite() throws Throwable{
        try {

            WebDriver driver = getWebDriver();

            config cfg = ConfigFactory.create(config.class);

            driver.navigate().to(cfg.hostname());
//            System.out.println("Site is open! Site title:" + getWebDriver().getTitle());

            WebElement element = driver.findElement(By.xpath("//a[@title='Отзывы']"));
            driver.navigate().refresh();
            element.click();

//            driver.findElement();


        } catch (Throwable throwable) {
            Assert.assertTrue(false, "Can't open site becouse: \n" + throwable.getCause());
            throwable.printStackTrace();
        }

    }

}
