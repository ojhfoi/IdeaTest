package ojhfoi.tears;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterSuite;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class tearsDown {

    @Autowired
//    @AfterSuite(description = "Close browser and driver")
    public void CloseDriver() {
        if (getWebDriver() != null) {
            getWebDriver().quit();
        }
    }

}
