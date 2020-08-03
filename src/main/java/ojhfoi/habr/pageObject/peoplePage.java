package ojhfoi.habr.pageObject;

import org.openqa.selenium.By;

public class peoplePage {

    public static By userPost = By.xpath("//div[@class='tabs']//a[contains(@href,'post')]");
    public static By userFavorites = By.xpath("//div[@class='tabs']//a[contains(@href,'favorites')]");


}
