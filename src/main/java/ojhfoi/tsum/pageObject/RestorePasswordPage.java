package ojhfoi.tsum.pageObject;

import org.openqa.selenium.By;

public class RestorePasswordPage {

    public static By emailInput = By.xpath("//input[@placeholder='Email']");
    public static By sendMailButton = By.xpath("//button[contains(@type,'submit') and contains(@class, 'button_large' )]");

}
