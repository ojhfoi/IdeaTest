package ojhfoi.tsum.pageObject;

import org.openqa.selenium.By;

public class CartPage {

    public static By deleteProduct = By.xpath("//span[contains(@class,'delete-control')]");
    public static By usePromoButton = By.xpath("//form[contains(@class,'promo')]//div");
    public static By inputPromo = By.xpath("//form[contains(@class,'promo')]//input");
    public static By not = By.xpath("//div[contains(@class,'notice error')]//span");

}
