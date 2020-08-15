package ojhfoi.stepdefinition.Habr;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ojhfoi.Waiting.waiting;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static ojhfoi.habr.pageObject.mainPage.*;

/**
 * Action on habr main page
 * @see ojhfoi.habr.pageObject.mainPage
 */
public class mainPageAction {

    /**
     * click on login button
     * @throws Exception error
     */
    @When("Click on login button on mane page")
    public void LoginClick() throws Exception{
        $(login).should(Condition.appear).click();
        waiting.WaitLoadPage();
    }

    /**
     * click on registration button
     * @throws Exception error
     */
    @When("Click on registration button on mane page")
    public void ClickRegistration() throws Exception{
        $(registration).should(Condition.appear).click();
        waiting.WaitLoadPage();
    }

    /**
     * click on Author links on top menu
     * @throws Exception error
     */
    @When("Click on Authors link")
    public void goToAuthorPage() throws Exception{
        $(authors).should(Condition.appear).click();
        waiting.WaitLoadPage();
    }

    /**
     * seek and click on author of post
     * @param postNum - post number for search
     * @throws Exception error
     */
    @And("Search post author by post number {int}")
    public void postAuthors(int postNum) throws Exception{
        $$(authorPost).get(postNum-1).click();
        waiting.WaitLoadPage();
    }

    /**
     * search post by post name
     * @param text - name
     * @throws Exception error
     */
    @And("Search post on main page by post name {string}")
    public void searchPost(String text) throws Exception{
        $(search).should(Condition.appear).click();
        $(searchInput).should(Condition.appear).sendKeys(text, Keys.ENTER);
        waiting.WaitLoadPage();
    }

    /**
     * change habr services
     * @param serviceNum services number in drop list
     * @throws Exception error
     */
    @And("Change habr service on service by number {int} in habr dropmenu")
    public void changeHabr(int serviceNum) throws Exception{
        $(changeHabr).should(Condition.appear).click();
        waiting.WaitLoadPage();
        $$(habServiceList).get(serviceNum - 1).click();
        waiting.WaitLoadPage();
    }

    /**
     * select period in filter for display post per this period
     * @param period period for filtering
     * @throws Exception error
     */
    @Then("Select date filter period {string} for filter post per period")
    public void selectDatePeriodOnTop(String period) throws Exception{
        List<WebElement> periodList = getWebDriver().findElements(top);
        if(periodList.isEmpty()){
            System.out.println("Date period on top list is empty! Check it manual");
        }else{
            $$(top).findBy(Condition.text(period)).click();
        }
    }

    /**
     * Seek post in news(block in mane page after first post) and click on comment by post num
     * @param newsNum - number of post in news block
     * @throws Exception error
     */
    @Then("Search post by number {int} in news block and click on comments link")
    public void searchPostInNewsAndCLickComment(int newsNum) throws Exception{
        List<WebElement> newsCommentList = getWebDriver().findElements(newBlockComments);
        if (newsCommentList.isEmpty()){
            newsCommentList.get(newsNum - 1).click();
        }
    }


}
