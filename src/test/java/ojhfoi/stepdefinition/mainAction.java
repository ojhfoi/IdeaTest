package ojhfoi.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import ojhfoi.tsum.pageObject.TsumMainPage;
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
    @And("change goods category")
    public void changeGender(){
        $(gender).click();
    }

    /**
     * change goods category on clothes
     */
    @Then("go to clothe category")
    public void goToClothe(){
        $(clothe).click();
    }

    /**
     * change goods category on shoes
     */
    @Then("go to shoes category")
    public void goToshoes(){
        $(shoes).click();
    }

    /**
     * change goods category on bag
     */
    @Then("go to bag category")
    public void goToBag(){
        $(bag).click();
    }

    /**
     * change goods category on accesory
     */
    @Then("go to accessory category")
    public void goToAccessory(){
        $(accessory).click();
    }

    /**
     * change goods category on new goods
     */
    @Then("go to new goods category")
    public void goToNewGoods(){
        $(newGoods).click();
    }

    /**
     * search goods in search bar
     * @param text - what's good we search
     */
    @And("search good \"([^\"]*)\"")
    public void search(String text){
        $(search).click();
        $(search).sendKeys(text, Keys.ENTER);
    }

}
