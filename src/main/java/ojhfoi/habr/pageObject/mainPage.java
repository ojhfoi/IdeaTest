package ojhfoi.habr.pageObject;

import org.openqa.selenium.By;

public class mainPage {

    public static By login = By.xpath("//a[@id='login']");
    public static By search = By.xpath("//button[@id='search-form-btn']");
    public static By lang = By.xpath("//button[contains(@class,'js-show_lang_setting')]");
    public static By links = By.xpath("//ul[@id='navbar-links']");
    public static By changeHabr = By.xpath("//span[@id='dropdown-control']");
    public static By habServiceList = By.xpath("//a[@class='service']");
    public static By registration = By.xpath("//a[contains(@class,'btn_navbar_registration')]");
    public static By authors = By.xpath("//div[@class='tabs']//a[contains(@href,'users') and not(contains(@title,'Автор публикации'))]");
    public static By postList = By.xpath("//div[@class='posts_list']//ul//li[contains(@id,'post')]//a[contains(@class,'post__title_link')]");
    public static By authorPost = By.xpath("//a[@title='Автор публикации']");
    public static By postLink = By.xpath("//li[contains(@class,'item_post')]");
    public static By postTag = By.xpath("//li[contains(@class,'item_hub')]//a");
    public static By top = By.xpath("//a[contains(@href,'top') and contains(@class,'toggle-menu')]");
    public static By newBlockComments = By.xpath("//div[contains(@class,'new-block')]//a[contains(@href,'#comments') and not(contains(@class,'comments-new'))]");

}
