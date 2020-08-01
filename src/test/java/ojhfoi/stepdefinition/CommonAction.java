package ojhfoi.stepdefinition;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ojhfoi.Waiting.waiting;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import javax.persistence.ElementCollection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;
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
    @When("set filter {string} active")
    public void clickOnFilter(String filterText) throws Exception{
        waiting.WaitLoadPage();
        List<WebElement> filterList = getWebDriver().findElements(activateFilter);
        if (filterList.isEmpty()){
            System.out.println("Filter is empty");
        }else{
            $$(activateFilter).findBy(Condition.text(filterText)).should(Condition.appear).click();
            waiting.WaitLoadPage();
        }
    }

    /**
     * Set products size
     * @param filterText - size
     */
    @And("choose shoes size at {string}")
    public void ChooseSize(String filterText) throws Exception{
//        $(size).click();
        waiting.WaitLoadPage();
        List<WebElement> filterList = getWebDriver().findElements(setSizeFilter);
        if (filterList.isEmpty()){
            System.out.println("Filter list is empty!");
        }else{
            $$(setSizeFilter)
                    .findBy(Condition.attribute("title", filterText))
                    .scrollIntoView(false)
                    .should(Condition.appear).sendKeys(Keys.ENTER);
        }
        waiting.WaitLoadPage();
    }

    /**
     * Choose filter on page. Filter as men, women, child or etc
     * @param filterName - filter name
     */
    @Then("click on filter \"([^\"]*)\"")
    public void chooseFilterClass(String filterName) throws Exception{
        List<WebElement> filterList = getWebDriver().findElements(filterClass);
        if(filterList.isEmpty()){
            System.out.println("Filter is empty");
        }else {
            $$(filterClass).findBy(Condition.text(filterName)).click();
        }
        waiting.WaitLoadPage();
    }

    /**
     * Select product by brand filter
     * @param brandName - brand name for search
     */
    @And("set brand filter by brand {string}")
    public void selectBrandFilter(String brandName) throws Exception{
        waiting.WaitLoadPage();
        $(brandInput).scrollTo().should(Condition.appear).sendKeys(brandName);
        waiting.WaitLoadPage();
        List<WebElement> brandList = getWebDriver().findElements(brand);
        if(brandList.isEmpty()){
            System.out.println("Brand filter list is empty!");
        }else {
            $$(brand)
                    .findBy(Condition.text(brandName))
                    .should(Condition.appear)
                    .scrollIntoView(false)
                    .click();
            getWebDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            waiting.WaitLoadPage();
        }
    }

    @Then("set other filter {string}")
    public void SetOtherFilter(String filterName) throws Exception{
        waiting.WaitLoadPage();
        List<WebElement> otherList = getWebDriver().findElements(otherFilter);
        if(otherList.isEmpty()){
            System.out.println("Brand filter list is empty!");
        }else {
            $$(otherFilter)
                    .findBy(Condition.text(filterName))
                    .scrollIntoView(false)
                    .should(Condition.appear)
                    .click();
            waiting.WaitLoadPage();
        }
    }

    /**
     * Search and select product on page by
     * product num
     * @param productNum - product num on page
     */
    @Deprecated
    public void selectProduct(int productNum){
        waiting.WaitLoadPage();
        List<WebElement> productList = getWebDriver().findElements(chooseProducts);
        if(productList.isEmpty()){
            System.out.println("No product on page!");
        }else {
            productList.get(productNum).click();
            waiting.WaitLoadPage();
        }
    }

    /**
     * Search and selet product on page
     * by product name and product number
     * On page can be located some element with equal name
     * @param productName - product name on page
     * @param productNum - product number on page
     */
    @And("select product name {string} and product number {int} on page")
    public void selectProduct(String productName, int productNum){
        waiting.WaitLoadPage();
        List<WebElement> productList = getWebDriver().findElements(chooseProducts);
        if(productList.isEmpty()){
            System.out.println("No product on page!");
        }else {
            $$(chooseProducts)
                    .filterBy(Condition.text(productName))
                    .get(productNum)
                    .scrollIntoView(false)
                    .should(Condition.visible)
                    .click();
            waiting.WaitLoadPage();
        }
    }

}
