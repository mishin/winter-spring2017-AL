package base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        System.out.println("GOT HERE");
        ApplicationContext context = SpringApplication.run(Application.class, args);
    }
}