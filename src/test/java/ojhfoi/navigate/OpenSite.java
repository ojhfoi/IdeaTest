package ojhfoi.navigate;

import Allert.AllertWind;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ojhfoi.navigate.config.config;
import ojhfoi.tsum.pageObject.TsumMainPage;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static ojhfoi.Waiting.waiting.WaitLoadPage;
import static check.myElemCheck.myCheck;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class OpenSite {

    @Test(description = "Переходим на сайт", priority = 0)
    public void OpenSite() throws Throwable{
        try {

            WebDriver driver = getWebDriver();

            config cfg = ConfigFactory.create(config.class);

            driver.navigate().to(cfg.hostname());

        } catch (Throwable throwable) {
            Assert.assertTrue(false, "Can't open site becouse: \n" + throwable.getCause());
            throwable.printStackTrace();
        }

    }

    @Test(description = "Открываем категорию Смартфоны", priority = 1)
    public void MoveToMob() throws Throwable{
        try {
            WaitLoadPage();

            //Проверяем, что появилось ок подтверждения города
            SelenideElement element =  $("button._2s55WErgIp.BCVQlNQsVv");

            if(element.isDisplayed()){
                element.click();
            }

            WaitLoadPage();

            //Переходим в категорию Электроника / Смартфоны
            $x("//a[contains(@href,'/catalog--elektronika/')]").shouldBe(Condition.appear).click();
            WaitLoadPage();
            $x("//a[contains(@href, '/catalog--smartfony') and contains(@class,'_9qbcyI_fyS')]").shouldBe(Condition.appear).click();

            WaitLoadPage();

            //Выбираем модели. ЗЫ: производителя ReadMe нет, это тот же Xiaomi.
            $x("//input[@name='Производитель Xiaomi']/../div//span").shouldBe(Condition.appear).click();
            $x("//input[@name='Производитель realme']/../div//span").shouldBe(Condition.appear).click();

            WaitLoadPage();

            //Кликаем на фильтр сортировки по цене.
            $x("//div[contains(@data-bem,'price') and contains(@class,'sorter')]").click();

            //Выбираем первую найденную модель realme и добавляем в сравнение
            $x("//img[contains(@class,'image') and contains(@alt, 'realme')]")
                    .shouldBe(Condition.appear).scrollIntoView(true).hover();
            $x("//a[contains(@class,'hovered_yes')]/..//div[contains(@class,'compare')]")
                    .shouldBe(Condition.appear)
                    .click();

            AllertWind.AlertAccept();
            WaitLoadPage();

            //Выбираем модел Xiaomi для сравнения
            $x("//img[contains(@class,'image') and contains(@alt, 'Xiaomi')]").shouldBe(Condition.appear).hover();
            $x("//a[contains(@class,'hovered_yes')]/..//div[contains(@class,'compare')]")
                    .shouldBe(Condition.appear)
                    .click();

            AllertWind.AlertAccept();
            WaitLoadPage();

            //Переходим в сравнение
            $x("//a[contains(@href,'/compare')]").click();

            WaitLoadPage();

            if ($$x("//div[contains(@data-bem,'compare-cell')]").size() == 2){
                System.out.println("Телефоны добавлены для сравнения");
            }else{
                System.out.println("Телефоны не были выбраны для сравнения");
                Throwable throwable = new Throwable("Телефоны не выбраны!");
                Throwable throwable1 = new Throwable();
                throwable1.initCause(throwable);
                throw throwable1;
            }

            //Включаем все характеристики
            $x("//span[contains(@class,'controls__all')]").click();

            WaitLoadPage();
            //Проверяем видимость элемента
            myCheck("//div[contains(@class,'row-name') and contains(text(),'Операционная система')]/../../../div[contains(@class,'_equal-values') and not(contains(@class,'hidden_yes'))]");

            //Переходим на различающиеся характеристики
            $x("//span[contains(@class,'controls__diff')]").click();

            WaitLoadPage();
            //Проверяем видимость элемента
            myCheck("//div[contains(@class,'row-name') and contains(text(),'Операционная система')]/../../../div[contains(@class,'_equal-values') and not(contains(@class,'hidden_yes'))]");


        }catch (Throwable throwable){
            Assert.assertTrue(false, "Ошибка " + throwable.getCause());
            throwable.printStackTrace();
        }
    }

}
