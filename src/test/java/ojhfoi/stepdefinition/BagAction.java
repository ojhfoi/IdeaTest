package ojhfoi.stepdefinition;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static ojhfoi.tsum.pageObject.bagPageObject.*;

/**
 * Action on Bag goods page
 */
public class BagAction {

    /**
     * Set filter as exclusive
     */
    @And("set exclusive filter")
    public void ChooseExclusive(){
        $(exclusive).click();
    }

    /**
     * Sort products
     * @param sortBy - by sort?
     */
    @Then("sort good by \"([^\"])\"")
    public void sortGoods(String sortBy){
        $(sort).click();
        $$(sortUl).findBy(Condition.text(sortBy)).click();
    }

    /**
     * Go to product page
     * @param productNum - number of products on page
     */
    @Then("choose products on page by (\\d+) number")
    public void ChooseProductByNum(int productNum){
        List<WebElement> productList = getWebDriver().findElements(product);
        if (productList.isEmpty()){
            System.out.println("List of products is empty!");
        }else{
            productList.get(productNum).click();
        }
    }

    /**
     * Watch all image on preview gallery
     */
    @And("Watch products photo on gallery")
    public void seeGalery(){
        int i = 0;
        List<WebElement> galerySize = getWebDriver().findElements(galery);
        if (galerySize.isEmpty()){
            System.out.println("Gallery is empty!");
        }else{
            while (i < galerySize.size()){
                $(galeryArrow).click();
            }
        }
    }

}
