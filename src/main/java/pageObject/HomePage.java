package pageObject;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    static By dropmenu = By.xpath(".//p[contains(@class,'header2-menu__item-text__username')]");
    static By myProfile = By.xpath(".//b[contains(@class,'header2-menu__dropdown-text_name')]");

    public static void openProfile(){
        $(dropmenu).hover();
        $(myProfile).click();
    }

}
