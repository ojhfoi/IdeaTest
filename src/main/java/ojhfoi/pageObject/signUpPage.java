package ojhfoi.pageObject;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * Sign Up page element
 */
public class signUpPage {

    private static By mail = By.name("email");
    private static By pass = By.name("password");
    private static By pass2 = By.name("password");
    private static By login = By.name("login");
    private static By submit = By.name("go");

    /**
     * Mail input element
     * @return
     */
    public static WebElement mailSignInp(){
        WebElement emailInp = $(mail).should(Condition.appear);
        return emailInp;
    }

    /**
     * Password input element
     * @return
     */
    public static WebElement passSignInp(){
        WebElement passInp = $(pass).should(Condition.appear);
        return passInp;
    }

    /**
     * Repeat password input
     * @return
     */
    public static WebElement pass2SignInp(){
        WebElement pass2Inp = $(pass2).should(Condition.appear);
        return pass2Inp;
    }

    /**
     * Username input
     * @return
     */
    public static WebElement loginSignInp(){
        WebElement logInp = $(login).should(Condition.appear);
        return logInp;
    }

    /**
     * Submit button
     * @return
     */
    public static WebElement submitSignButt(){
        WebElement signSibButt = $(submit).should(Condition.appear);
        return signSibButt;
    }
}
