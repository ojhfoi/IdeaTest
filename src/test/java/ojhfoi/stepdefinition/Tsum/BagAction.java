package ojhfoi.stepdefinition.Tsum;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import ojhfoi.Waiting.waiting;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
    public void ChooseExclusive() throws Exception{
        $(exclusive).click();
        waiting.WaitLoadPage();
    }

    /**
     * Sort products
     * @param sortBy - by sort?
     */
    @Then("sort good by {string}")
    public void sortGoods(String sortBy) throws Exception{
        $(sort).click();
        waiting.WaitLoadPage();
        $$(sortUl).findBy(Condition.text(sortBy)).click();
        waiting.WaitLoadPage();
    }

    /**
     * Go to product page
     * @param productNum - number of products on page
     */
    @Then("choose products on page by {int} number")
    public void ChooseProductByNum(int productNum) throws Exception{
        getWebDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        waiting.WaitLoadPage();
        List<WebElement> productList = getWebDriver().findElements(product);
        if (productList.isEmpty()){
            System.out.println("List of products is empty!");
        }else{
            $$(product).get(productNum).should(Condition.appear).click();
            waiting.WaitLoadPage();
        }
    }

    /**
     * Watch all image on preview gallery
     */
    @And("Watch products photo on gallery")
    public void seeGalery() throws Exception{
        waiting.WaitLoadPage();
        int i = 0;
        List<WebElement> galerySize = getWebDriver().findElements(galery);
        if (galerySize.isEmpty()){
            System.out.println("Gallery is empty!");
        }else{
            while (i < galerySize.size()){
                $(galeryArrow).should(Condition.appear).click();
                i++;
                waiting.WaitLoadPage();
            }
        }
    }

    @And("select image {int} in galery")
    public void selectInGallery(int numInGallery) throws Exception{
        waiting.WaitLoadPage();
        int i = 0;
        List<WebElement> galerySize = getWebDriver().findElements(galery);
        if (galerySize.isEmpty()){
            System.out.println("Gallery is empty!");
        }else{
            while (i < numInGallery){
                $(galeryArrow).click();
                i++;
            }
        }
        waiting.WaitLoadPage();
    }

}
