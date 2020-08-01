package ojhfoi.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import ojhfoi.Waiting.waiting;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static ojhfoi.tsum.pageObject.shoesPage.*;

/**
 * Action on shoes page
 */
public class shoesAction {

    /**
     * Go to page
     * @param numPage - number of page
     */
    @Given("go to page (\\d+)")
    public void goToPage(int numPage) throws Exception{
        List<WebElement> pageList = getWebDriver().findElements(changePage);
        if (pageList.size()!=0){
            pageList.get(numPage).click();
        }else{
            System.out.println("List of goods is empty!");
        }
        waiting.WaitLoadPage();
    }

    /**
     * Choose sport shoes category on page
     */
    @Then("choose sport shoes goods")
    public void ChooseSportShoes() throws Exception{
        $(sportShoes).click();
        waiting.WaitLoadPage();
    }

    /**
     * Choose sneakers filter in sport shoes category
     */
    @And("choose sneakers category")
    public void ChooseSneakers() throws Exception{
        $(sneakers).click();
        waiting.WaitLoadPage();
    }

}
