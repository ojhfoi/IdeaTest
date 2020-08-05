package ojhfoi.habr.pageObject;

import org.openqa.selenium.By;

/**
 * Element of login page
 */
public class loginPage {

    public static By mail = By.name("email");
    public static By pass = By.name("password");
    public static By submit = By.name("go");
    public static By vkButton = By.xpath("//a[contains(@class,'button_vkontakte')]");
    public static By gitButton = By.xpath("//a[contains(@class,'button_github')]");
    public static By googleButton = By.xpath("//a[contains(@class,'google')]");

}
