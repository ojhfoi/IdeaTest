package ojhfoi.tsum.pageObject;

import org.openqa.selenium.By;

public class AccessoryPage {

    public static By scarf = By.xpath("//li//a[@title='Шарфы']");
//    public static By activateColorFilter = By.xpath("//div[contains(@class,'filter__title') and contains(text(),'Цвета')]");
    public static By setColorFilter = By.xpath("//a[contains(@href,'color')]");
    public static By setBrand = By.xpath("//a[contains(@href,'brand')and contains(@href,'sort')]");

}
