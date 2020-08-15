package ojhfoi.stepdefinition.Habr;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import ojhfoi.Waiting.waiting;

import static com.codeborne.selenide.Selenide.$;
import static ojhfoi.habr.pageObject.loginPage.*;

/**
 * Action with login page element
 */
public class loginPageAction {

    /**
     * Fill in login form
     * @param email - user account email
     * @param password - user account password
     * @throws Exception error
     */
    @Given("Fill in user email {string} and user password {string}")
    public void insertAuthData(String email, String password) throws Exception{
        waiting.WaitLoadPage();
        $(mail).should(Condition.appear).sendKeys(email);
        $(pass).should(Condition.appear).sendKeys(password);
    }

    /**
     * Click on submit button
     * @throws Exception error
     */
    @And("Submit authentication")
    public void clickSubmitAuth() throws Exception{
        $(submit).should(Condition.appear).click();
        waiting.WaitLoadPage();
    }

}
