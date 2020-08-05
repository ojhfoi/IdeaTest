package ojhfoi.stepdefinition.Habr;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import ojhfoi.Waiting.waiting;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static ojhfoi.habr.pageObject.userProfile.*;

/**
 * Action on user profile page
 */
public class userProfilePage {

    /**
     * Click on users post link
     * @throws Exception error
     */
    @Then("Got to users post category")
    public void watchPeoplePosts() throws Exception{
        $(userPost).should(Condition.appear).click();
        waiting.WaitLoadPage();
    }

    /**
     * Click on users favorites link
     * @throws Exception error
     */
    @Then("Go to users favorites category")
    public void watchPeopleFavorites() throws Exception{
        $(userFavorites).should(Condition.appear).click();
        waiting.WaitLoadPage();
    }

    /**
     * Click on user Rating in profile
     * @throws Exception error
     */
    @Then("Click on user rating in profile")
    public void clickOnUserRating() throws Exception{
        $(rating).should(Condition.appear).click();
        waiting.WaitLoadPage();
    }

    /**
     * Click on user Carma in profile
     * @throws Exception error
     */
    @Then("Click on user carma")
    public void clickOnUserCarma() throws Exception{
        $(carma).should(Condition.appear).click();
        waiting.WaitLoadPage();
    }

    /**
     * Click on user comments link in user profile
     * @throws Exception error
     */
    @Given("Click on user comments link")
    public void clickOnUserCommentsLink() throws Exception{
        $(comments).should(Condition.appear).click();
        waiting.WaitLoadPage();
    }

    /**
     * Click by number on link to user comments in post
     * @param commentNum comment number
     * @throws Exception error
     */
    @Then("Click on user comment {int} and go to post with this comment")
    public void clickOnLinkToComment(int commentNum) throws Exception{
        waiting.WaitLoadPage();
        List<WebElement> commentList = getWebDriver().findElements(linkToComment);
        if(commentList.isEmpty()){
            System.out.println("User haven't comment now");
        }else {
            commentList.get(commentNum);
            waiting.WaitLoadPage();
        }
    }

}
