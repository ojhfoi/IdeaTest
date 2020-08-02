package ojhfoi.tsum.pageObject;

import org.openqa.selenium.By;

/**
 * Common page object for general element on all page
 */
public class CommonPageObject {

    public static By activateFilter = By.xpath("//div[contains(@class,'filter__title')]");

    public static By showMorePage = By.xpath("//div[contains(@class,'showmore')]//button");

    public static By otherFilter = By.xpath("//label[contains(@for,'additional')]//a");

    public static By chooseProducts = By.xpath("//p[contains(@class,'product__description')]");

    public static By setSizeFilter = By.xpath("//a[contains(@href,'size')]");

    public static By filterClass = By.xpath("//a[contains(@class,'category__title')]");

    public static By brandInput = By.xpath("//input[contains(@placeholder,'Поиск по брендам')]");

    public static By brand = By.xpath("//div[contains(@class,'checkbox')]//a[contains(@href,'brand')]");

    public static By cart = By.xpath("//a[@title='Корзина']");

}
