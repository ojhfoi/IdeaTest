package home.ojhfoi.steps;

import com.codeborne.selenide.Condition;
import ojhfoi.Waiting.waiting;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import static ojhfoi.pageObject.mainPage.*;

@Component
public class Test5 {

    @Bean
    public void checkBestPostByTag() throws Exception {
        HabrLogo().click();
        waiting.WaitLoadPage();
        PostTag().get(1).click();
        postFilterList().findBy(Condition.text("Лучшие")).click();
        datePeriod().findBy(Condition.text("Всё время")).click();
    }

}
