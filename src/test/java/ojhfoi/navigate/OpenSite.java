package ojhfoi.navigate;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.Test;


import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.lang.Thread.sleep;

public class OpenSite {

    @Test(description = "run site")
    public void OpenSite() throws Throwable{
        try {

            getWebDriver().navigate().to("http://otus.ru");
            System.out.println("Site is open! Site title:" + getWebDriver().getTitle());

        } catch (Throwable throwable) {
            Assert.assertTrue(false, "Can't open site becouse: \n" + throwable.getCause());
            throwable.printStackTrace();
        }

    }

}
