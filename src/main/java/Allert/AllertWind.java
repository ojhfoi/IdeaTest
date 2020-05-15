package Allert;

import static Waiting.waiting.WaitLoadPage;
import static com.codeborne.selenide.Selenide.$x;

public class AllertWind {

    //Получаем текст со всплывающего таба и закрываем его
    public static void AlertAccept(){
        WaitLoadPage();
        String text = $x("//div[contains(@class,'informer__title')]").getText();
        System.out.println(text);
        $x("//div[contains(@class,'name_close')]").click();
    }

}
