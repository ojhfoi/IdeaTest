package ojhfoi.stepdefinition;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static ojhfoi.tsum.pageObject.CommonPageObject.*;

/**
 * Basic action, which we can do on all page
 */
public class CommonAction {

    /**
     * Doing filter on page active
     * @param filterText - name of filter
     */
    @When("set filter \"([^\"]*)\"")
    public void clickOnFilter(String filterText){
        List<WebElement> filterList = getWebDriver().findElements(activateFilter);
        if (filterList.isEmpty()){
            System.out.println("Filter is empty");
        }else{
            $$(activateFilter).findBy(Condition.text(filterText)).click();
        }
    }

    /**
     * Set products size at 39
     */
    @And("choose shoes size at \"([^\"]*]\"")
    public void ChooseSize(String filterText){
//        $(size).click();
        List<WebElement> filterList = getWebDriver().findElements(setSizeFilter);
        if (filterList.isEmpty()){
            System.out.println("Filter list is empty!");
        }else{
            $$(setSizeFilter).findBy(Condition.text(filterText)).click();
        }
    }

    /**
     * Choose filter on page. Filter as men, women, child or etc
     * @param filterName - filter name
     */
    @Then("click on filter \"([^\"]*]\"")
    public void chooseFilterClass(String filterName){
        List<WebElement> filterList = getWebDriver().findElements(filterClass);
        if(filterList.isEmpty()){
            System.out.println("Filter is empty");
        }else {
            $$(filterClass).findBy(Condition.text(filterName)).click();
        }
    }

    /**
     * Select product by brand filter
     * @param brandName - brand name for search
     */
    @And("set brand filter by brand \"([^\"]*]\"")
    public void selectBrandFilter(String brandName){
        List<WebElement> brandList = getWebDriver().findElements(brand);
        if(brandList.isEmpty()){
            System.out.println("Brand filter list is empty!");
        }else {
            $$(brand).findBy(Condition.text(brandName)).click();
        }
    }

}
