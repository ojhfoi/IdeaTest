package ojhfoi.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import ojhfoi.Waiting.waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Element of Authors Page
 */
public class authorPage {

    public static By searchAuthor = By.xpath("//input[@id='people_suggest']");
    public static By peoples = By.xpath("//ul[@id='peoples']//a[contains(@class,'fullname')]");

    /**
     * Search bar for search Author
     * @throws Exception error
     * @return
     */
    public static WebElement searchAuthorBar() throws Exception{
        waiting.WaitLoadPage();
        WebElement searchAuthorBar = $(searchAuthor).should(Condition.appear);
        return searchAuthorBar;
    }

    /**
     * Author list for select
     * @throws Exception error
     * @return
     */
    public static List<WebElement> selectAuthor() throws Exception{
        List<WebElement> authorList = getWebDriver().findElements(peoples);
        if (authorList.isEmpty()){
            System.out.println("Author on page not found");
        }else {
            ElementsCollection peopleList = $$(peoples);
        }
        return authorList;
    }

}
