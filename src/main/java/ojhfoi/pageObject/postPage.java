package ojhfoi.pageObject;

import ojhfoi.Waiting.waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Element of post page
 */
public class postPage {

    public static By commentVote = By.xpath("//button[contains(@data-action,'plus') and contains(@onclick,'comment')]");

    /**
     * Eah.... uncover our plusomet and give turn of plus by selected comments
     * @throws Exception error. well, somebody stayed without plus on his comments
     * @return
     */
    public static List<WebElement> uncoverPlusomet() throws Exception{
        waiting.WaitLoadPage();
        List<WebElement> commentList = getWebDriver().findElements(commentVote);
        if (commentList.isEmpty()){
            System.out.println("Post haven't any comments!");
        }
        return commentList;
    }


}
