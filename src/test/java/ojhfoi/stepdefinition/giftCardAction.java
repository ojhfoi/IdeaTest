package ojhfoi.stepdefinition;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import ojhfoi.Waiting.waiting;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static ojhfoi.tsum.pageObject.giftCardPage.*;

/**
 * Gift Card page action
 */
public class giftCardAction {

    /**
     * Chose gift card skin
     */
    @And("choose gift card classic skin")
    public void ChoseGiftCardSkin() throws Exception{
        $$(giftSkin).findBy(Condition.visible).click();
        waiting.WaitLoadPage();
    }

    /**
     * Select summ for gift card
     * @param priceSumm - summ on gift card for selection
     */
    @And("select summ {string} on gift card")
    public void selectPriceCard(String priceSumm) throws Exception{
        $(priceOnCard).click();
        waiting.WaitLoadPage();
        List<WebElement> priceList = getWebDriver().findElements(price);
        if (priceList.isEmpty()){
            System.out.println("No price for gift card!");
        }else {
            $$(price).findBy(Condition.text(priceSumm)).click();
        }
        waiting.WaitLoadPage();
    }

}
