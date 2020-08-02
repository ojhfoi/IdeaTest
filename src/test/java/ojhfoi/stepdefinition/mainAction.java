package ojhfoi.stepdefinition;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ojhfoi.Waiting.waiting;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static ojhfoi.tsum.pageObject.TsumMainPage.*;

/**
 * action with main page of site tsum.ru
 */
public class mainAction {

    /**
     * change gender category for goods
     */
    @And("change goods category by gender")
    public void changeGender() throws Exception{
        $(gender).click();
        waiting.WaitLoadPage();
    }

    /**
     * change goods category on clothes
     */
    @Then("go to clothe category")
    public void goToClothe() throws Exception{
        $(clothe).click();
        waiting.WaitLoadPage();
    }

    /**
     * change goods category on shoes
     */
    @Then("go to shoes category")
    public void goToShoes() throws Exception{
        $(shoes).click();
        waiting.WaitLoadPage();
    }

    /**
     * change goods category on bag
     */
    @Then("go to bag category")
    public void goToBag() throws Exception{
        $(bag).click();
        waiting.WaitLoadPage();
    }

    /**
     * change goods category on accesory
     */
    @Then("go to accessory category")
    public void goToAccessory() throws Exception{
        $(accessory).click();
        waiting.WaitLoadPage();
    }

    /**
     * change goods category on new goods
     */
    @Then("go to new goods category")
    public void goToNewGoods() throws Exception{
        $(newGoods).click();
        waiting.WaitLoadPage();
    }

    /**
     * search goods in search bar
     * @param text - what's good we search
     */
    @And("search good {string}")
    public void search(String text) throws Exception{
        $(searchActivate).should(Condition.appear).click();
        waiting.WaitLoadPage();
        $(searchInput).should(Condition.appear).sendKeys(text, Keys.ENTER);
        waiting.WaitLoadPage();
    }

    /**
     * Click on user personal cabinet button
     */
    @Given("go to user personal cabinet")
    public void goToAuthPage() throws Exception{
        $(userCab).click();
        waiting.WaitLoadPage();
    }

    /**
     * go to gift card page
     */
    @When("choose gift card product")
    public void goToGiftCart() throws Exception{
        $(giftCard).click();
        waiting.WaitLoadPage();
    }

}
