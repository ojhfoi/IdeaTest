package ojhfoi.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import ojhfoi.Waiting.waiting;

import static com.codeborne.selenide.Selenide.$;
import static ojhfoi.tsum.pageObject.clothePage.*;

/**
 * Action on clothe page
 */
public class clotheAction {

    /**
     * Search brand in filter
     * @param brand - brand name for search
     */
    @Deprecated
    public void searchBrand(String brand) throws Exception{
        $(brandSearch).sendKeys(brand);
        waiting.WaitLoadPage();
    }

    /**
     * Choose shorts product
     */
    @Then("go to shorts product category")
    public void chooseShortsProduct() throws Exception{
        $(shorts).click();
        waiting.WaitLoadPage();
    }

    /**
     * Choose jeans shorts product
     */
    @And("select jeans shorts product category")
    public void chooseJeansShorts() throws Exception{
        $(type).click();
        waiting.WaitLoadPage();
    }

    /**
     * Disable InStock filter
     */
    @And("disable in stock filter")
    public void uncheckInStockFilter() throws Exception{
        $(inStock).click();
        waiting.WaitLoadPage();
    }

    /**
     * Choose dress product
     */
    @Then("select dress product category")
    public void chooseDressProduct() throws Exception{
        $(dress).click();
        waiting.WaitLoadPage();
    }

}
