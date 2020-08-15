package ojhfoi.stepdefinition.Habr;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import ojhfoi.Waiting.waiting;

import static com.codeborne.selenide.Selenide.$;
import static ojhfoi.habr.pageObject.careerMainPage.vacanciesTopMenu;

/**
 * Action on career service main page
 */
public class careerMainPageAction {

    /**
     * Search and click on Vacancy page link
     * @throws Exception error
     */
    @And("Go to Vacancy page")
    public void clickOnVacancyLink() throws Exception {
        $(vacanciesTopMenu).should(Condition.appear).click();
        waiting.WaitLoadPage();
    }

}
