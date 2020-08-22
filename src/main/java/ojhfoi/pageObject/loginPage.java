package ojhfoi.pageObject;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * Element of login page
 */
public class loginPage {

    public static By mail = By.name("email");
    public static By pass = By.name("password");
    public static By submit = By.name("go");
    private static By signUpLink = By.xpath("//a[contains(@href,'register')]");

    /**
     * Search and return email input
     * @return
     * @throws Exception error
     */
    public static WebElement emailInp() throws Exception{
        WebElement mailInp =  $(mail).should(Condition.appear);
        return mailInp;
    }

    /**
     * Search and return password input
     * @return
     * @throws Exception
     */
    public static WebElement passwordInp() throws Exception{
        WebElement passInp = $(pass).should(Condition.appear);
        return passInp;
    }

    /**
     * Click on submit button
     * @throws Exception error
     */
    public static WebElement SubmitAuthButton() throws Exception{
        WebElement authButton =  $(submit).should(Condition.appear);
        return authButton;
    }

    /**
     * search link to sign up page
     * @return
     * @throws Exception
     */
    public static WebElement signUp() throws Exception{
        WebElement signLink = $(signUpLink).should(Condition.appear);
        return signLink;
    }

}
