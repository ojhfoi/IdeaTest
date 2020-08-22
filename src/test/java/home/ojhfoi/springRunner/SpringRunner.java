package home.ojhfoi.springRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringRunner.class, args);
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("home.ojhfoi", "ojhfoi");
//        context.getBean("OpenSite");
    }

}
