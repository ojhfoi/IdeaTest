package ojhfoi.stepdefinition.Habr;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import ojhfoi.Waiting.waiting;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static ojhfoi.habr.pageObject.vacanciesPage.*;

/**
 * Career habr services
 * Action on vacancies page section
 */
public class vacanciesPageAction {

    /**
     * Search vacancies through search input
     * @param vacanciesName - vacancies name
     * @throws Exception error
     */
    @Given("Insert vacancies {string} in search bar")
    public void vacanciesSearchBar(String vacanciesName) throws Exception{
        $(searchVacancies).should(Condition.appear).sendKeys(vacanciesName, Keys.ENTER);
        waiting.WaitLoadPage();
    }

    /**
     * Set qualification filter by qualification name for search vacancies
     * @param qualificationName - qualification name
     * @throws Exception error
     */
    @And("Set qualification filter by qualification {string}")
    public void setQualificationFilter(String qualificationName) throws Exception{
        $(qualificationFilter).should(Condition.appear).click();
        List<WebElement> optionList = getWebDriver().findElements(qualificationFilterOption);
        if (optionList.isEmpty()){
            System.out.println("Qualification filter options are empty!");
        }else {
            $$(qualificationFilterOption)
                    .findBy(Condition.text(qualificationName))
                    .should(Condition.appear)
                    .click();
            waiting.WaitLoadPage();
        }
    }

    /**
     * Fill in salary filter
     * @param salary - salary
     * @throws Exception error
     */
    @And("Set salary filter by salary {string}")
    public void fillSalaryFilter(String salary) throws Exception{
        $(salaryFilterInput).should(Condition.appear).sendKeys(salary);
        waiting.WaitLoadPage();
    }

}
