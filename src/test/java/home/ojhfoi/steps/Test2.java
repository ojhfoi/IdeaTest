package home.ojhfoi.steps;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import static ojhfoi.pageObject.mainPage.HabrLogo;
import static ojhfoi.pageObject.userProfile.userCarmaLink;

@Component
public class Test2 {

    @Bean("test 2")
    public Test2 checkCarma(Test1 test1) throws Exception{
        HabrLogo().click();
        test1.searchAuthor();
        userCarmaLink().click();
        return new Test2();
    }

}
