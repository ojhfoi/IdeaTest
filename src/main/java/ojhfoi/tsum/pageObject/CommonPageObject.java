package ojhfoi.tsum.pageObject;

import org.openqa.selenium.By;

/**
 * Common page object for general element on all page
 */
public class CommonPageObject {

    public static By activateFilter = By.xpath("//div[contains(@class,'filter__nav-filter')]");

    public static By showMorePage = By.xpath("//button[@class='button']");

    public static By otherFilter = By.xpath("//input[contains(@id,'additional')]");

    public static By chooseProducts = By.xpath("//p[contains(@class,'product__description')]");

    public static By setSizeFilter = By.xpath("//a[contains(@href,'size')]");

    public static By filterClass = By.xpath("//a[contains(@class,'category__title')]");

    public static By brand = By.xpath("//a[contains(@href,'brand')]");

    public static By cart = By.xpath("//a[@title='Корзина']");


}
