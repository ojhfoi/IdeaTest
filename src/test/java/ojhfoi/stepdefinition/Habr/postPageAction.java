package ojhfoi.stepdefinition.Habr;

import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static ojhfoi.habr.pageObject.postPage.commentVote;

/**
 * Action on post page
 */
public class postPageAction {

    /**
     * Eah.... uncover our plusomet and give turn of plus by selected comments
     * @throws Exception error. well, somebody stayed without plus on his comments
     */
    @And("Send ray of godness on comment by number {int}")
    public void uncoverPlusomet(int commentNum) throws Exception{
        List<WebElement> commentList = getWebDriver().findElements(commentVote);
        if (commentList.isEmpty()){
            System.out.println("Post haven't any comments!");
        }else {
            commentList.get(commentNum - 1 ).click();
        }
    }

}
