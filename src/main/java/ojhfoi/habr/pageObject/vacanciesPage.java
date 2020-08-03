package ojhfoi.habr.pageObject;

import org.openqa.selenium.By;

public class vacanciesPage {

    public static By searchVacancies = By.xpath("//input[@placeholder='Поиск']");
    public static By qualificationFilter = By.xpath("//div[contains(text(),'Квалификация')]/../div[2]/select");
    public static By salaryFilterInput = By.xpath("//div[contains(text(),'Зарплата')]/../div[2]//input[@inputmode='numeric']");

}
