package Allert;

import static ojhfoi.Waiting.waiting.WaitLoadPage;
import static com.codeborne.selenide.Selenide.$x;

public class AllertWind {

    //Получаем текст со всплывающего таба и закрываем его
    public static void AlertAccept(){
        WaitLoadPage();
        $x("//button[contains(@class,'__close-button')]").click();
    }

}
