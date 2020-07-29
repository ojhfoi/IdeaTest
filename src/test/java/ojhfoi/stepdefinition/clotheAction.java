package ojhfoi.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

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
    public void searchBrand(String brand){
        $(brandSearch).sendKeys(brand);
    }

    /**
     * Choose shorts product
     */
    @Then("go to shorts product category")
    public void chooseShortsProduct(){
        $(shorts).click();
    }

    /**
     * Choose jeans shorts product
     */
    @And("select jeans shorts product category")
    public void chooseJeansShorts(){
        $(type).click();
    }

    /**
     * Disable InStock filter
     */
    @And("disable in stock filter")
    public void uncheckInStockFilter(){
        $(inStock).click();
    }

    /**
     * Choose dress product
     */
    @Then("select dress product category")
    public void chooseDressProduct(){
        $(dress).click();
    }

}
