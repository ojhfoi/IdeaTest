package ojhfoi.tsum.pageObject;

import org.openqa.selenium.By;

/**
 * Purchase page object
 */
public class PurchasePage {

    public static By buyerName = By.xpath("//input[@formcontrolname='name']");
    public static By buyerSurName = By.xpath("//input[@formcontrolname='surname']");
    public static By buyerPhone = By.xpath("//input[@formcontrolname='phone']");
    public static By buyerEmail = By.xpath("//input[@formcontrolname='email']");


}
