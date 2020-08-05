package ojhfoi.stepdefinition.Tsum;

import com.codeborne.selenide.Condition;
import gherkin.lexer.Th;
import io.cucumber.java.en.And;
import ojhfoi.Waiting.waiting;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static ojhfoi.tsum.pageObject.AccessoryPage.*;

/**
 * Accessory page action class
 */
public class AccessoryAction {

    /**
     * Select scarf category
     * @throws Exception error
     */
    @And("select scarf category of accessory product")
    public void setScarfCategory() throws Exception{
        $(scarf).click();
        waiting.WaitLoadPage();
    }

    /**
     * Select color in color filter
     * @param color - color for search in color list
     */
    //TODO: Carry over this method in CommonAction class
    @And("select color {string} in filter")
    public void setColorFilter(String color){
        waiting.WaitLoadPage();
        List<WebElement> colorList = getWebDriver().findElements(setColorFilter);
        if(colorList.isEmpty()){
            System.out.println("May be filter isn't active? Color list is empty!");
        }else{
            $$(setColorFilter)
                    .findBy(Condition.attribute("title", color))
                    .scrollIntoView(true)
                    .should(Condition.appear)
                    .click();
            waiting.WaitLoadPage();
        }
    }

}
