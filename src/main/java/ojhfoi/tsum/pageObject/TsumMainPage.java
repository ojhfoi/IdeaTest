package ojhfoi.tsum.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

/**
 * Page Object of main page tsum.ru
 */
public class TsumMainPage {

    public static By gender = By.xpath("//top-main-menu//span[contains(@class,'header__gender') and contains(text(),'Мужское')]");
    public static By clothe = By.xpath("//a[@title='Одежда']");
    public static By shoes = By.xpath("//a[@title='Обувь']");
    public static By bag = By.xpath("//a[@title='Сумки']");
    public static By accessory = By.xpath("//a[@title='Аксессуары']");
    public static By newGoods = By.xpath("//a[@title='Новинки']");
    public static By search = By.xpath("//input[@name='q']");
    static By userCab = By.xpath("//a[@href='/login/']");

}
