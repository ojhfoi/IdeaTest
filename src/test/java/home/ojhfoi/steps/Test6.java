package home.ojhfoi.steps;

import ojhfoi.Waiting.waiting;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import static ojhfoi.pageObject.mainPage.*;
import static ojhfoi.pageObject.postPage.uncoverPlusomet;

@Component
public class Test6 {

    @Bean
    public void checkNews() throws Exception {
        HabrLogo().click();
        waiting.WaitLoadPage();
        CommentInNewsLink().get(1).click();
        waiting.WaitLoadPage();
        uncoverPlusomet().get(0).click();
    }

}
