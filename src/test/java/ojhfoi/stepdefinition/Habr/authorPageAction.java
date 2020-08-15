package ojhfoi.stepdefinition.Habr;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Given;
import ojhfoi.Waiting.waiting;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static ojhfoi.habr.pageObject.authorPage.peoples;
import static ojhfoi.habr.pageObject.authorPage.searchAuthor;

/**
 * Action on Author category page
 */
public class authorPageAction {

    /**
     * Insert Author name in search bar
     * @param authorName Author name
     * @throws Exception error
     */
    @Given("Search author by name {string} through search bar")
    public void searchAuthorByName(String authorName) throws Exception{
        $(searchAuthor).should(Condition.appear).sendKeys(authorName, Keys.ENTER);
        waiting.WaitLoadPage();
    }

    /**
     * Search and select Author by author name
     * @param authorName author name. nothing else
     * @throws Exception error
     */
    @Given("Search and click on author {string} on page")
    public void selectAuthor(String authorName) throws Exception{
        List<WebElement> authorList = getWebDriver().findElements(peoples);
        if (authorList.isEmpty()){
            System.out.println("Author on page not found");
        }else {
            $$(peoples).findBy(Condition.text(authorName)).click();
        }
    }

}
