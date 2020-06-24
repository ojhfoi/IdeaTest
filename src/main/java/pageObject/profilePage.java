package pageObject;

import Waiting.waiting;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class profilePage {

//    static By comm = By.xpath("//div[contains(@class,'input_no-border-right lk-cv-block__input_fake') and not contains(@text,'')]");
    static By comm = By.xpath("//div[contains(@class,'input_no-border-right lk-cv-block__input_fake')]//span");
    static By commType = By.xpath("//div[@data-num='0']//button[@data-value='telegram']");
    static By commType2 = By.xpath("//div[@data-num='1']//button[@data-value='vk']");
    static By addCommType = By.xpath("//button[contains(@class,'lk-cv-block__action_md-no-spacing js-formset-add')]");
    static By save = By.xpath("//button[@name='continue']");
    static By inputComm = By.xpath("//input[@name='contact-0-value']");
    static By inputComm2 = By.xpath("//input[@name='contact-1-value']");
    static By personprofile = By.xpath("//div[@class='container__row']//a[@title='Персональные данные']");
    static By deleteComm = By.xpath("//div[contains(@class,'md-0')]//button[contains(@class,'js-formset-delete')]");

    public static void addComm(String tel, String vk){

        $(comm).click();
        $(commType).click();
        $(inputComm).sendKeys(tel);
        waiting.WaitLoadPage();
        $(addCommType).click();
        $(comm).click();
        $(commType2).click();
        $(inputComm2).sendKeys(vk);
    }

    public static void saveProf(){
        $(save).click();
    }

    public static void deleteComm(){
        $(personprofile).click();
        $(deleteComm).click();
    }

}
