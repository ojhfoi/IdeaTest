package ojhfoi.pageObject;

import org.openqa.selenium.By;

public class loginPage {

    static By mail = By.name("email");
    static By pass = By.name("password");
    static By submit = By.name("go");
    static By vkButton = By.xpath("//a[contains(@class,'button_vkontakte')]");
    static By gitButton = By.xpath("//a[contains(@class,'button_github')]");
    static By googleButton = By.xpath("//contains(@class,'google')");

}
