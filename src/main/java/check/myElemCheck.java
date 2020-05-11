package check;

import static Waiting.waiting.WaitLoadPage;
import static com.codeborne.selenide.Selenide.$$x;

public class myElemCheck {

    //Проверяем видимость элемента на странице по xpath
    public static void myCheck(String xpath){
        WaitLoadPage();
        if ($$x(xpath).size()>0){
            System.out.println("Элемент присутствует на странице");
        }else {
            System.out.println("Элемента на странице нет");
        }
    }

}
