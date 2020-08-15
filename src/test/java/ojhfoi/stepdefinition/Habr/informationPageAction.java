package ojhfoi.stepdefinition.Habr;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;

import javax.lang.model.element.Element;

import static com.codeborne.selenide.Selenide.$;
import static ojhfoi.habr.pageObject.careerMainPage.vacanciesTopMenu;

/**
 * Action with element of information page
 */
public class informationPageAction {

    @And("Check that information page is loaded")
    public void checkPageStatus() throws Exception{
        WebElement element = $(vacanciesTopMenu).should(Condition.appear);
        if(element.isDisplayed()){
            System.out.println("Page check is success");
        }else {
            Exception ex = new Exception("Page check isn't succes");
            Exception thr = new Exception();
            thr.initCause(ex);
        }
    }

}
