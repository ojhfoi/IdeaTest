package ojhfoi.tsum.pageObject;

import org.openqa.selenium.By;

/**
 * Page Object of Bag page
 */
public class bagPageObject {

    public static By exclusive = By.xpath("//a[contains(@title,'Эксклюзивно') and contains(@href,'/sumki')]/../../input[@type='checkbox']");
    public static By sort = By.name("sort");
    public static By sortUl = By.xpath("//span[@class='select__text']");
    public static By product = By.xpath("//a[contains(@class,'product__image-wrapper')]");
    public static By galery = By.xpath("//div[@slider='photos']//div[@class='slider-preview__item']//img[@role='presentation']");
    public static By galeryArrow = By.xpath("//span[contains(@class,'slider-preview__arrow_type_next')]");

}
