package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LoginPage {

//    @FindBy(xpath = ".//button[contains(@class,'header2__auth')]")
//    private static WebElement goAuth;
//
//    @FindBy(xpath = ".//input[contains(@name,'email') and contains(@class,'js-email-input')]")
//    private static WebElement login;
//
//    @FindBy(name = "password")
//    private static WebElement pass;
//
//    @FindBy(xpath = ".//button[contains(@type,'submit') and contains(text(),'Войти')]")
//    private static WebElement checkAuth;

    static By goAuth = By.xpath(".//button[contains(@class,'header2__auth')]");
    static By login = By.xpath(".//input[contains(@name,'email') and contains(@class,'js-email-input')]");
    static By pass = By.name("password");
    static By checkAuth = By.xpath(".//button[contains(@type,'submit') and contains(text(),'Войти')]");

    public static void auth(String mylogin, String myPass){
       $(goAuth).click();
       $(login).sendKeys(mylogin);
       $(pass).sendKeys(myPass);
       $(checkAuth).click();
    }

}
