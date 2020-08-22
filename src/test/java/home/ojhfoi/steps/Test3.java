package home.ojhfoi.steps;

import ojhfoi.pageObject.mainPage;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import static ojhfoi.pageObject.userProfile.userRateLink;

@Component
public class Test3 {

    @Bean("test 3")
    public Test3 checkRating(Test1 test1) throws Exception{
        mainPage.HabrLogo().click();
        test1.searchAuthor();
        userRateLink().click();
        return new  Test3();
    }

}
