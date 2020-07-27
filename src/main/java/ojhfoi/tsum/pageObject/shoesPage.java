package ojhfoi.tsum.pageObject;

import org.openqa.selenium.By;

/**
 * page object of shoes goods page
 */
public class shoesPage {

    public static By sportShoes = By.xpath("//a[@title='Спортивная обувь']");
    public static By sneakers = By.xpath("//a[@title='Кроссовки']/../../input[@type='checkbox']");
    public static By size = By.xpath("//div[contains(@class,'filter__title') and contains(text(),'Размеры')]");
    public static By sizeChoose = By.xpath("//a[@title='39']/../../input[@type='checkbox']");
    public static By changePage = By.xpath("//span[contains(@class,'pagination__link')]//a");
}
