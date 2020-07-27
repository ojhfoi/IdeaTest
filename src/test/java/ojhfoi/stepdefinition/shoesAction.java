package ojhfoi.stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static ojhfoi.tsum.pageObject.shoesPage.changePage;

public class shoesAction {

    WebDriver driver = getWebDriver();

    public void goToPage(int numPage){
        List<WebElement> pageList = driver.findElements(changePage);
        if (pageList.size()!=0){
            pageList.get(numPage).click();
        }else{
            System.out.println("List of goods is empty!");
        }
    }

    //public void

}
