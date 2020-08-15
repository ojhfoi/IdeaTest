package ojhfoi.habr.pageObject;

import org.openqa.selenium.By;

/**
 * Element of post page
 */
public class postPage {

    public static By commentVote = By.xpath("//button[contains(@data-action,'plus') and contains(@onclick,'comment')]");


}
