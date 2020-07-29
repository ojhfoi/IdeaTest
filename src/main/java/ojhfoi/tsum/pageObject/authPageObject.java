package ojhfoi.tsum.pageObject;

import org.openqa.selenium.By;

/**
 * Authorization page object
 */
public class authPageObject {

    public static By clientemail = By.xpath("//input[@placeholder='Email']");
    public static By clientpass = By.xpath("//input[@type='password']");
    public static By authSubmit = By.xpath("//button[contains(@class,'button_block')]");

}
