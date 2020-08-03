package ojhfoi.habr.pageObject;

import org.openqa.selenium.By;

public class userProfile {

    public static By raiting = By.xpath("//a[@title='Рейтинг пользователя']");
    public static By carma = By.xpath("//a[contains(@href,'karma') and not(contains(@title,'Рейтинг'))]");
    public static By comments = By.xpath("//a[contains(@href,'comments')]");
    public static By linkToComment = By.xpath("//a[@title='Ссылка на комментарий']");

}
