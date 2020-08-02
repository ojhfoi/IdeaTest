package ojhfoi.stepdefinition;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import ojhfoi.Waiting.waiting;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static ojhfoi.tsum.pageObject.CartPage.*;

/**
 * Action on Cart Page
 */
public class CartAction {

    /**
     * Delete added product from cart
     * @throws Exception
     */
    @And("delete add product from cart")
    public void deleteFromCart() throws Exception{
        $(deleteProduct).should(Condition.appear).click();
        waiting.WaitLoadPage();
    }

    @And("use promo code {string}")
    public void userPromo(String promoCode){
        $(usePromoButton).should(Condition.appear).click();
        $(inputPromo).should(Condition.appear).sendKeys(promoCode, Keys.ENTER);
        waiting.WaitLoadPage();
        if ($(not).isDisplayed() && $(not).getText().equals("Такого промокода не существует")){
            System.out.println("Promo code is not valid");
        }else {
            System.out.println("Promo code is valid and succeeds");
        }
    }

}
