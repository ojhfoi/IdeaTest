package home.ojhfoi.steps;

import org.openqa.selenium.Keys;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import static ojhfoi.pageObject.authorPage.searchAuthorBar;
import static ojhfoi.pageObject.authorPage.selectAuthor;
import static ojhfoi.pageObject.mainPage.AuthorPageLink;
import static ojhfoi.pageObject.userProfile.userFavorLink;
import static ojhfoi.pageObject.userProfile.userPostLink;


@Component
public class Test1 {

    @Bean("test 1")
    public Test1 searchAuthor() throws Exception {
        AuthorPageLink().click();
        searchAuthorBar().sendKeys("Игорь Кацуба", Keys.ENTER);
        selectAuthor().get(0).click();
        return new Test1();
    }

    public Test1 checkRating() throws Exception{
        userPostLink().click();
        userFavorLink();
        return new  Test1();
    }


}
