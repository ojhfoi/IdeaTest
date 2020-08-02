package ojhfoi.stepdefinition;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import ojhfoi.Waiting.waiting;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static ojhfoi.tsum.pageObject.RestorePasswordPage.emailInput;
import static ojhfoi.tsum.pageObject.RestorePasswordPage.sendMailButton;
import static ojhfoi.tsum.pageObject.authPageObject.*;

/**
 * Action on client authorization page
 */
public class authAction {

    /**
     * Insert user data
     * @param email - client email
     * @param password - client password
     */
    @Then("insert user email {string} and user password {string}")
    public void insertUserData(String email, String password) throws Exception{
        waiting.WaitLoadPage();
        $(clientemail).sendKeys(email);
        waiting.WaitLoadPage();
        $(clientpass).sendKeys(password);
        waiting.WaitLoadPage();
    }

    /**
     * Click on submit button for authorization
     */
    @And("click on submit button")
    public void submitAuth() throws Exception{
        $(authSubmit).click();
        waiting.WaitLoadPage();
    }

    /**
     * Check authorization after insert user data and click submit
     * @throws Exception
     */
    @And("check authorization status and insert email {string} if auth fail")
    public void checkAuth(String email) throws Exception{
        waiting.WaitLoadPage();
        getWebDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        if ($(notice).isDisplayed() && $(notice).getText().equals("Неверный логин или пароль")){
            System.out.println("Authorization failure! Restore pass start");
            $(restorePass).should(Condition.appear).click();
            waiting.WaitLoadPage();
            $(emailInput).should(Condition.appear).sendKeys(email);
            $(sendMailButton).should(Condition.appear).click();
            waiting.WaitLoadPage();
        }else {
            System.out.println("Authorization is succes");
        }

    }

}
