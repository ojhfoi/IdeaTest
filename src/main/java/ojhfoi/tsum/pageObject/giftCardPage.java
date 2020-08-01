package ojhfoi.tsum.pageObject;

import org.openqa.selenium.By;

public class giftCardPage {

    public static By giftSkin = By.xpath("//div[contains(@class,'slider-preview__image')]//img[contains(@src,'ba71')]");
    public static By giftValue = By.xpath("//input[@type='number']");
    public static By priceOnCard = By.xpath("//div[@class='select__current']");
    public static By price = By.xpath("//li[contains(@class,'select__item')]//span");


}
