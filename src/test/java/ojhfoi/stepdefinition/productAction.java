package ojhfoi.stepdefinition;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.mn.Харин;
import ojhfoi.Waiting.waiting;
import org.openqa.selenium.WebElement;

import javax.persistence.ElementCollection;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static ojhfoi.tsum.pageObject.ProductPageObject.*;
import static org.assertj.core.api.BDDAssertions.and;

/**
 * Action on product page
 */
public class productAction {

    /**
     * Choose color of product in rgb color system. In example: 0, 0, 0 - black color
     * @param r - red color value
     * @param g - green color value
     * @param b - blue color value
     */
    @And("chose color on rgb: {string}, {string}, {string}")
    public void chooseColor(String r, String g, String b) throws Exception{
        List<WebElement> colorList = getWebDriver().findElements(color);
        if(colorList.isEmpty()){
            System.out.println("Product haven't any color!");
        }else{
            $$(color)
                    .findBy(Condition.attribute("style", "background-color: rgb("+r+", "+g+", "+b+");"))
                    .shouldBe(Condition.appear)
                    .click();
        }
        waiting.WaitLoadPage();
    }

    /**
     * Click on fast buy button on product page
     */
    @When("click fast buy product")
    public void fastBuyProduct() throws Exception{
        $(fastBuy).click();
        waiting.WaitLoadPage();
    }

    /**
     * Insert value in input on fast buy form
     * @param name - client name
     * @param phone - client phone
     */
    @And("insert client name {string} and client phone {string}")
    public void fastBuyInsertData(String name, String phone) throws Exception{
        $(fastBuyName).sendKeys(name);
        waiting.WaitLoadPage();
        $(fastBuyPhone).sendKeys(phone);
        waiting.WaitLoadPage();
    }

    /**
     * Add product in cart
     * @throws Exception
     */
    @And("add product in cart")
    public void addCart() throws Exception{
        $(addCart).click();
        waiting.WaitLoadPage();
        ElementsCollection elem = $$(catrNotif);
        if (elem.size() > 0){
            System.out.println("Product is added in cart");
        }else {
            System.out.println("Product isn't added in cart");
        }
    }

    /**
     * Go to cart page
     */
    @And("go to cart")
    public void goToCart(){
        $(goToCart).should(Condition.appear).click();
        waiting.WaitLoadPage();
    }



    /**
     * Sometimes color filter on product page
     * can be located in combobox.
     * This method used for this situation
     * @param colorName - color name for select
     */
    @And("select color {string} in combobox")
    public void selectColorInComb(String colorName){
        waiting.WaitLoadPage();
        $(combColor).click();
        waiting.WaitLoadPage();
        List<WebElement> colorList = getWebDriver().findElements(combColorList);
        if(colorList.isEmpty()){
            System.out.println("List of color is empty!");
        }else {
            $$(combColorList)
                    .findBy(Condition.text(colorName))
                    .shouldBe(Condition.visible)
                    .click();
            waiting.WaitLoadPage();
        }
    }

    /**
     * Select size on product page
     * @param size - size for search
     * @throws Exception error
     */
    @And("select size {string} for product")
    public void selectProductSize(String size) throws Exception{
        waiting.WaitLoadPage();
        $(productSizeComb).shouldBe(Condition.appear).click();
        waiting.WaitLoadPage();
        List<WebElement> sizeList = getWebDriver().findElements(productSizeCombList);
        if (sizeList.isEmpty()){
            System.out.println("Not available size for this product");
        }else {
            $$(productSizeCombList)
                    .findBy(Condition.text(size))
                    .shouldBe(Condition.appear)
                    .click();
            waiting.WaitLoadPage();
        }
    }

}
