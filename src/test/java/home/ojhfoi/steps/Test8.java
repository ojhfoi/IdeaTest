package home.ojhfoi.steps;

import com.codeborne.selenide.Condition;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import static ojhfoi.pageObject.loginPage.*;
import static ojhfoi.pageObject.mainPage.*;
import static ojhfoi.pageObject.vacanciesPage.*;

@Component
public class Test8 {

    @Bean
    public void changeHabrByClassic() throws Exception{
        vacancyChangeHabr().get(0).should(Condition.appear).click();
    }

    @Bean
    public void checkLogin() throws Exception{
        LoginButton().click();
        emailInp().sendKeys("test@test.ru");
        passwordInp().sendKeys("test");
        SubmitAuthButton().click();
    }

}
