package ojhfoi.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import ojhfoi.Waiting.waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Element of vacancies page in career habr services
 */
public class vacanciesPage {

    public static By vacancyMenuLink = By.xpath("//div[contains(@class,'header')]//a[contains(@href,'vacancies')]");
    public static By searchVacancies = By.xpath("//input[@placeholder='Поиск']");
    public static By qualificationFilter = By.xpath("//div[contains(text(),'Квалификация')]/../div[2]//select");
    public static By qualificationFilterOption = By.xpath("//div[contains(text(),'Квалификация')]/../div[2]//select//option");
    public static By salaryFilterInput = By.xpath("//div[contains(text(),'Зарплата')]/../div[2]//input[@inputmode='numeric']");
    private static By divisionFilter = By.xpath("//div[contains(@class,'__division')]//span[contains(@class,'__content')]");
    private static By clearFilter = By.xpath("//div[@class='filters-controls']//button");
    private static By cityFilter = By.xpath("//input[@placeholder='Введите город']");
    private static By logoVacanciesPage = By.xpath("//a[contains(@class,'logo') and contains(@title,'Хабр')]");
    private static By vacancyHabrService = By.xpath("//div[contains(@class,'__logo-wrapper')]//button");
    private static By vacancyHabrServList = By.xpath("//a[contains(@class,'service')]");
    private static By suggestionFilterDropdown = By.xpath("//button[contains(@class,'suggestion')]");


    /**
     * Vacancies tab link
     * @return
     */
    public static WebElement VacancyTabLink() throws Exception{
        WebElement vacanciesLink = $(vacancyMenuLink).should(Condition.appear);
        return vacanciesLink;
    }

    /**
     * Vacancies search bar input
     * @return
     * @throws Exception error
     */
    public static WebElement vacanciesSearchBar() throws Exception{
        WebElement vaccabcySeacrhBar = $(searchVacancies).should(Condition.appear);
        return vaccabcySeacrhBar;
    }

    /**
     * ElementCollection of qualification filter
     * @return
     * @throws Exception error
     */
    public static ElementsCollection setQualificationFilter() throws Exception{
        $(qualificationFilter).should(Condition.appear).click();
        ElementsCollection optionList = $$(qualificationFilterOption);
        if (optionList.isEmpty()){
            System.out.println("Qualification filter options are empty!");
        }
        return optionList;
    }

    /**
     * Fill in salary filter
     * @return
     * @throws Exception error
     */
    public static WebElement fillSalaryFilter() throws Exception{
        WebElement salaryFilter = $(salaryFilterInput).should(Condition.appear);
        return salaryFilter;
    }

    /**
     * List of division filter
     * @return
     * @throws
     */
    public static ElementsCollection divisionFilterList() throws Exception{
        ElementsCollection divisionList = $$(divisionFilter);
        return divisionList;
    }

    /**
     * Clear filter button on vacancy tab
     * @return
     * @throws Exception
     */
    public static WebElement clearFilterButton() throws Exception{
        WebElement clearButton = $(clearFilter).should(Condition.appear).scrollIntoView(true);
        return clearButton;
    }

    /**
     * Input city in filter block
     * @return
     * @throws
     */
    public static WebElement cityFilterInput() throws Exception{
        WebElement cityInput = $(cityFilter).should(Condition.appear);
        return cityInput;
    }

    /**
     * Specify for vacancies habr services. Habr logo(refresh button)
     * @return
     * @throws Exception
     */
    public static WebElement HabrVacLogo() throws Exception{
        WebElement habrLogo = $(logoVacanciesPage).should(Condition.appear);
        return habrLogo;
    }

    /**
     * Specifiy for vacancy habr services. Dropdown menu with habr services link
     * @return
     * @throws Exception
     */
    public static ElementsCollection vacancyChangeHabr() throws Exception{
        waiting.WaitLoadPage();
        $(vacancyHabrService).should(Condition.appear).click();
        waiting.WaitLoadPage();
        ElementsCollection vhabrServiceList = $$(vacancyHabrServList);
        waiting.WaitLoadPage();
        return vhabrServiceList;
    }

    /**
     * Dropdown menu with search result. For Suggestion filter
     * @return
     * @throws Exception
     */
    public static ElementsCollection suggestionMenu() throws Exception{
        ElementsCollection suggestionList = $$(suggestionFilterDropdown);
        if (suggestionList.isEmpty()){
            System.out.println("Suggestion list is empty!");
        }
        return suggestionList;
    }

}
