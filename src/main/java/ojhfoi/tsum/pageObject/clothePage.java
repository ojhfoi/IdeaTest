package ojhfoi.tsum.pageObject;

import org.openqa.selenium.By;

/**
 * Page object of clothe page
 */
public class clothePage {

//    public static By brand = By.xpath("//div[contains(@class,'filter__title') and contains(text(),'Бренд')]");
    public static By brandSearch = By.xpath("//input[contains(@placeholder,'брендам')]");
    public static By shorts = By.xpath("//div[contains(@class,'category__name ')]//a[@title='Шорты']");
    public static By type = By.xpath("//a[@title='Джинсовые']/../../input[@type='checkbox']");
    public static By inStock = By.xpath("//a[@title='В наличии']/../../input[@type='checkbox']");
    public static By dress = By.xpath("//a[@title='Платья']");

}
