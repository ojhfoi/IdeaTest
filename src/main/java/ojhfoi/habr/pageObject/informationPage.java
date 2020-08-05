package ojhfoi.habr.pageObject;

import org.openqa.selenium.By;

/**
 * Element of information page
 */
public class informationPage {

    public static By carmaLink = By.xpath("//a[@title='Карма, рейтинг и вклад']"); //not used
    public static By ratingAnchor = By.xpath("//a[@name='rating']"); // not used
    public static By infoPage = By.xpath("//div[contains(@class,'info_page')]");

}
