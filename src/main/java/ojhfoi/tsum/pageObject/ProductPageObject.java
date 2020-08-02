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

    public static By addCart = By.xpath("//div[contains(@class,'item__add')]//button[contains(@class,'item__button')]");
    public static By goToCart = By.xpath("//a[@title='Корзина']");
    public static By catrNotif = By.xpath("//p[contains(@class,'added-to-cart')]");

    public static By combColor = By.xpath("//div[contains(@class,'color-switcher__color')]");
    public static By combColorList = By.xpath("//div[contains(@class,'color-switcher__color')]//div[@class='select__body']//span[@class='select__text']");

    public static By productSizeComb = By.xpath("//dropdown[@name='itemSize']//div[contains(@class,'select_size')]");
    public static By productSizeCombList = By.xpath("//dropdown[@name='itemSize']//span[contains(@class,'select__text')]");
}
