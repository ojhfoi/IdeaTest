package home.ojhfoi.navigation;

import ojhfoi.tears.BrowserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Component
public class OpenSite {

//    private LoginPage lp = PageFactory.initElements(driver, LoginPage.class);


//    @Test(description = "Переходим на сайт")
    @Bean("OpenSite")
    public void openSite() throws Throwable{
        try {
            getWebDriver().navigate().to("https://habr.com/ru/");

        } catch (Throwable throwable) {
            Assert.assertTrue(false, "Can't open site becouse: \n" + throwable.getCause());
            throwable.printStackTrace();
        }
    }

}
