package home.ojhfoi.steps;

import com.codeborne.selenide.Condition;
import ojhfoi.Waiting.waiting;
import org.openqa.selenium.Keys;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import static ojhfoi.pageObject.mainPage.*;
import static ojhfoi.pageObject.vacanciesPage.*;

@Component
public class Test7 {

    @Bean
    public void goToHabrVacancy() throws Exception {
        changeHabr().get(2).click();
        VacancyTabLink().click();
    }

    @Bean
    public void setFilter() throws Exception{
        divisionFilterList().find(Condition.text("Тестирование")).should(Condition.appear).click();
        setQualificationFilter().find(Condition.text("Средний (Middle)")).click();
        fillSalaryFilter().sendKeys("50000");
        cityFilterInput().sendKeys("Пермь");
        suggestionMenu().get(0).click();
        waiting.WaitLoadPage();
        clearFilterButton().click();
    }

}
