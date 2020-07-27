package ojhfoi.tsum.pageObject;

import org.openqa.selenium.By;

public class clothePage {

    public static By brand = By.xpath("//div[contains(@class,'filter__title') and contains(text(),'Бренд')]");
    static By brandSearch = By.xpath("//input[contains(@placeholder,'брендам')]");
    static By shorts = By.xpath("//div[contains(@class,'category__name ')]//a[@title='Шорты']");
    static By type = By.xpath("//a[@title='Джинсовые']/../../input[@type='checkbox']");
    static By inStock = By.xpath("//a[@title='В наличии']/../../input[@type='checkbox']");
    static By dress = By.xpath("//a[@title='Платья']");

}
