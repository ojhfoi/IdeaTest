package ojhfoi.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import ojhfoi.Waiting.waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Bean;

import static com.codeborne.selenide.Selenide.$;

/**
 * Element of main career service page
 */
public class careerMainPage {

    public static By vacanciesTopMenu = By.xpath("//div[@class='header__top_main_menu']//a[contains(@href,'vacancies')]");


    /**
     * Link to vacancies tabs
     * @throws Exception error
     * @return
     */
    public static WebElement OnVacancyLink() throws Exception {
        WebElement vacansiesLink = $(vacanciesTopMenu).should(Condition.appear);
        waiting.WaitLoadPage();
        return vacansiesLink;
    }

    /**
     * Check page status
     * @return
     * @throws Exception
     */
    public static WebElement checkPageStatus() throws Exception{
        WebElement element = $(vacanciesTopMenu).should(Condition.appear);
        if(element.isDisplayed()){
            System.out.println("Page check is success");
        }else {
            Exception ex = new Exception("Page check isn't succes");
            Exception thr = new Exception();
            thr.initCause(ex);
        }
        return element;
    }


}
