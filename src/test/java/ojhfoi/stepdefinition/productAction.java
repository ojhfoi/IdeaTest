package ojhfoi.stepdefinition;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import ojhfoi.Waiting.waiting;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static ojhfoi.tsum.pageObject.ProductPageObject.*;

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
    @And("chose color on rgb: \"[(^\")*]\", \"[(^\")*]\", \"[(^\")*]\"")
    public void chooseColor(String r, String g, String b) throws Exception{
        List<WebElement> colorList = getWebDriver().findElements(color);
        if(colorList.isEmpty()){
            System.out.println("Product haven't any color!");
        }else{
            $$(color).filterBy(Condition.cssValue("background-color", "rgb("+r+","+g+","+b+");"));
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
    @And("insert client name \"[(^\")*]\" and client phone \"[(^\")*]\"")
    public void fastBuyInsertData(String name, String phone) throws Exception{
        $(fastBuyName).sendKeys(name);
        waiting.WaitLoadPage();
        $(fastBuyPhone).sendKeys(phone);
        waiting.WaitLoadPage();
    }

    @And("add product in cart")
    public void addCart() throws Exception{
        $(addCart).click();
        waiting.WaitLoadPage();
    }

}
