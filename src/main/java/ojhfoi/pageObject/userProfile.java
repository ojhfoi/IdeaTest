package ojhfoi.pageObject;

import com.codeborne.selenide.Condition;
import ojhfoi.Waiting.waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Element of user profile page
 */
public class userProfile {

    public static By rating = By.xpath("//a[@title='Рейтинг пользователя']");
    public static By carma = By.xpath("//a[contains(@href,'karma') and not(contains(@title,'Рейтинг'))]");
    public static By comments = By.xpath("//a[contains(@href,'comments')]");
    public static By linkToComment = By.xpath("//a[@title='Ссылка на комментарий']");
    public static By userPost = By.xpath("//div[@class='tabs']//a[contains(@href,'post')]");
    public static By userFavorites = By.xpath("//div[@class='tabs']//a[contains(@href,'favorites')]");

    /**
     * Users post link
     * @throws Exception error
     * @return
     */
    public static WebElement userPostLink() throws Exception{
        WebElement userPostLink =  $(userPost).should(Condition.appear);
        waiting.WaitLoadPage();
        return userPostLink;
    }

    /**
     * Users favorites link
     * @throws Exception error
     * @return
     */
    public static WebElement userFavorLink() throws Exception{
        WebElement userFavoritesLink = $(userFavorites).should(Condition.appear);
        waiting.WaitLoadPage();
        return userFavoritesLink;
    }

    /**
     * User Rating in profile
     * @throws Exception error
     * @return
     */
    public static WebElement userRateLink() throws Exception{
        WebElement userRatingLink = $(rating).should(Condition.appear);
        waiting.WaitLoadPage();
        return userRatingLink;
    }

    /**
     * User Carma in profile
     * @throws Exception error
     * @return
     */
    public static WebElement userCarmaLink() throws Exception{
        WebElement userCarmalink = $(carma).should(Condition.appear);
        waiting.WaitLoadPage();
        return userCarmalink;
    }

    /**
     * User comments link in user profile
     * @throws Exception error
     * @return
     */
    public static WebElement userCommentLink() throws Exception{
        WebElement userComment = $(comments).should(Condition.appear);
        waiting.WaitLoadPage();
        return userComment;
    }

    /**
     * List of user's comment link
     * @return
     * @throws Exception error
     */
    public static List<WebElement> userCommentList() throws Exception{
        waiting.WaitLoadPage();
        List<WebElement> commentList = getWebDriver().findElements(linkToComment);
        if(commentList.isEmpty()){
            System.out.println("User haven't comment now");
        }
            return commentList;
    }

}
