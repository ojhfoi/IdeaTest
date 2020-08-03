package ojhfoi.habr.pageObject;

import org.openqa.selenium.By;

public class authorPage {

    public static By searchAuthor = By.xpath("//input[@id='people_suggest']");
    public static By peoples = By.xpath("//ul[@id='peoples']//a[contains(@class,'fullname')]");


}
