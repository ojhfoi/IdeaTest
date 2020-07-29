package ojhfoi.tsum.pageObject;

import org.openqa.selenium.By;

/**
 * Page object for product page
 */
public class ProductPageObject {

    public static By color = By.xpath("//span[contains(@class,'radio__wrapper')]");
    public static By fastBuy = By.xpath("//button[contains(@class,'one-click-button')]");
    public static By fastBuyName = By.xpath("//input[@formcontrolname='clientName']");
    public static By fastBuyPhone = By.xpath("//input[@formcontrolname='clientPhone']");
    public static By buyProductButton = By.xpath("//button[contains(@class,'buy__button')]");

}
