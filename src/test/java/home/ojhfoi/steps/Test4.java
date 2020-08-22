package home.ojhfoi.steps;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import static ojhfoi.pageObject.mainPage.*;
import static ojhfoi.pageObject.userProfile.*;

@Component
public class Test4 {

    @Bean
    public void checkComment() throws Exception {
        HabrLogo().click();
        postAuthors().get(0).click();
        userCommentLink().click();
        userCommentList().get(0).click();
    }

}
