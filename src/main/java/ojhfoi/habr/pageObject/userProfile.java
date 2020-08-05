package ojhfoi.habr.pageObject;

import org.openqa.selenium.By;

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

}
