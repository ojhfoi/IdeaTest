package home.ojhfoi.steps;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import static ojhfoi.pageObject.loginPage.*;
import static ojhfoi.pageObject.signUpPage.*;

@Component
public class Test9 {

    @Bean
    public void goToSignUpPage() throws Exception {
        signUp().click();
    }

    @Bean
    public void checkSignUp() throws Exception{
        mailSignInp().sendKeys("test@test.ru");
        loginSignInp().sendKeys("test");
        passSignInp().sendKeys("test");
        pass2SignInp().sendKeys("test");
        submitSignButt().click();
    }


}
