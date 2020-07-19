package ojhfoi.navigate;

import ojhfoi.navigate.config.config;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.profilePage;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class OpenSite {

    private LoginPage login = new LoginPage();
    private HomePage hp = new HomePage();
    private profilePage pp = new profilePage();

    private config cfg = ConfigFactory.create(config.class);
//    private LoginPage lp = PageFactory.initElements(driver, LoginPage.class);


    @Test(description = "Переходим на сайт", priority = 0)
    public void OpenSite() throws Throwable{
        try {
            getWebDriver().navigate().to(cfg.hostname());

        } catch (Throwable throwable) {
            Assert.assertTrue(false, "Can't open site becouse: \n" + throwable.getCause());
            throwable.printStackTrace();
        }

    }
    
    @Test(description = "Открываем и заполняем профиль", priority = 1)
    public void runTest() throws Throwable{
        try {
            login.auth(cfg.login(), cfg.pass());
            hp.openProfile();
            pp.addComm("ojhfoi", "ojhfoi");
            pp.saveProf();
            pp.deleteComm();
            pp.saveProf();
            pp.deleteComm();
        }catch (Throwable throwable){
            Assert.assertTrue(false, "Ошибка " + throwable.getCause());
            throwable.printStackTrace();
        }
    }

}
