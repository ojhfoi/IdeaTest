package ojhfoi.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static com.codeborne.selenide.Selenide.$;
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
    @Then("insert user email \"[(^\")*]\" and user password \"[(^\")*]\"")
    public void insertUserData(String email, String password){
        $(clientemail).sendKeys(email);
        $(clientpass).sendKeys(password);
    }

    /**
     * Click on submit button for authorization
     */
    @And("click on submit button")
    public void submitAuth(){
        $(authSubmit).click();
    }

}
