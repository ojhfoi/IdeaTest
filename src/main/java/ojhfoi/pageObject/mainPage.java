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
 * Page Element on main habr page
 */
public class mainPage {

    private static By login = By.xpath("//a[@id='login']");
    private static By search = By.xpath("//button[@id='search-form-btn']");
    private static By searchInput = By.xpath("//input[@name='q']");
    private static By lang = By.xpath("//button[contains(@class,'js-show_lang_setting')]");
    private static By links = By.xpath("//ul[@id='navbar-links']");
    private static By changeHabr = By.xpath("//span[@id='dropdown-control']");
    private static By habServiceList = By.xpath("//a[@class='service']");
    private static By registration = By.xpath("//a[contains(@class,'btn_navbar_registration')]");
    private static By authors = By.xpath("//div[@class='tabs']//a[contains(@href,'users') and not(contains(@title,'Автор публикации'))]");
    private static By postList = By.xpath("//div[@class='posts_list']//ul//li[contains(@id,'post')]//a[contains(@class,'post__title_link')]");
    private static By authorPost = By.xpath("//a[@title='Автор публикации']");
    private static By postLink = By.xpath("//li[contains(@class,'item_post')]");
    private static By postTag = By.xpath("//li[contains(@class,'item_hub')]//a");
    private static By top = By.xpath("//a[contains(@href,'top') and contains(@class,'toggle-menu')]");
    private static By newBlockComments = By.xpath("//div[contains(@class,'new-block')]//a[contains(@href,'#comments') and not(contains(@class,'comments-new'))]");
    private static By logo = By.xpath("//a[contains(@class,'logo')]");
    private static By postFilter= By.xpath("//div[contains(@class,'tabs-menu')]//a//h3");


    /**
     * List of post's tag
     * @throws Exception error
     * @return
     */
    public static List<WebElement> PostTag(){
        List<WebElement> postTagList = getWebDriver().findElements(postTag);
        return postTagList;
    }

    /**
     * login button
     * @throws Exception error
     * @return
     */
    public static WebElement LoginButton() throws Exception{
        WebElement loginButton = $(login).should(Condition.appear);
        waiting.WaitLoadPage();
        return loginButton;
    }

    /**
     * registration button
     * @throws Exception error
     * @return
     */
    public static WebElement RegistrationButton() throws Exception{
        WebElement regButton = $(registration).should(Condition.appear);
        waiting.WaitLoadPage();
        return regButton;
    }

    /**
     * Link to Author page
     * @throws Exception error
     * @return
     */
    public static WebElement AuthorPageLink() throws Exception{
        waiting.WaitLoadPage();
        WebElement auathorsPageLink = $(authors).should(Condition.appear);
        return auathorsPageLink;
    }

    /**
     * Link from post to author post
     * @return
     * @throws Exception error
     */
    public static ElementsCollection postAuthors() throws Exception{
       ElementsCollection authorList = $$(authorPost);
        waiting.WaitLoadPage();
        return authorList;
    }

    /**
     * Post
     * @return
     * @throws Exception error
     */
//    @Autowired
    public static WebElement searchPostBar() throws Exception{
        $(search).should(Condition.appear).click();
        WebElement searchPostBar = $(searchInput).should(Condition.appear);
        waiting.WaitLoadPage();
        return searchPostBar;
    }

    /**
     * Dropdown menu of habr service
     * @return
     * @throws Exception error
     */
    public static ElementsCollection changeHabr() throws Exception{
        $(changeHabr).should(Condition.appear).click();
        waiting.WaitLoadPage();
        ElementsCollection habrServiceList = $$(habServiceList);
        waiting.WaitLoadPage();
        return habrServiceList;
    }

    /**
     * select period in filter for display post per this period
     * @return
     * @throws Exception error
     */
    public static ElementsCollection datePeriod() throws Exception{
        ElementsCollection periodList = $$(top);
        if(periodList.isEmpty()){
            System.out.println("Date period on top list is empty! Check it manual");
        }
        return periodList;
    }

    /**
     * List of comment link from news block
     * @return
     * @throws Exception error
     */
    public static List<WebElement> CommentInNewsLink() throws Exception{
        List<WebElement> newsCommentList = getWebDriver().findElements(newBlockComments);
        if (newsCommentList.isEmpty()){
            System.out.println("Now comments in news block!");
        }
        return newsCommentList;
    }

    /**
     * Habr logo(or refresh button)
     * @return
     * @throws Exception
     */
    public static WebElement HabrLogo() throws Exception{
        WebElement habrLogo = $(logo).should(Condition.appear);
        return habrLogo;
    }

    /**
     * List of post's filter
     * @return
     * @throws Exception
     */
    public static ElementsCollection postFilterList() throws Exception{
        ElementsCollection filterList = $$(postFilter);
        return filterList;
    }

}
