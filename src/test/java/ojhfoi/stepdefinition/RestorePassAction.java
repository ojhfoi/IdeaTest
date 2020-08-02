package ojhfoi.stepdefinition;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import ojhfoi.Waiting.waiting;

import static com.codeborne.selenide.Selenide.$;
import static ojhfoi.tsum.pageObject.RestorePasswordPage.emailInput;
import static ojhfoi.tsum.pageObject.RestorePasswordPage.sendMailButton;

/**
 * Action on restore password page
 */
public class RestorePassAction {

    /**
     * Insert email for restore password
     * @param email - user email
     * @throws Exception
     */
    @And("insert email {string} for restore password")
    public void insertEmail(String email) throws Exception{
        waiting.WaitLoadPage();
        $(emailInput).should(Condition.appear).sendKeys(email);
    }

    /**
     * Click on submit button and send email with new pass
     * @throws Exception
     */
    @And("click on submit for send email")
    public void sendEmail()throws Exception{
        $(sendMailButton).should(Condition.appear).click();
        waiting.WaitLoadPage();
    }

}
