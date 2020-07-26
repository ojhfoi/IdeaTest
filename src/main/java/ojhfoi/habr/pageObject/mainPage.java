package ojhfoi.habr.pageObject;

import org.openqa.selenium.By;

public class mainPage {

    static By login = By.xpath("//a[@id='login']");
    static By search = By.xpath("//button[@id='search-form-btn']");
    static By lang = By.xpath("//button[contains(@class,'js-show_lang_setting')]");
    static By links = By.xpath("//ul[@id='navbar-links']");
    static By changeHabr = By.xpath("//span[@id='dropdown-control']");

}
