package an;

import an.framework.webdriver.WebManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        WebManager.get();
        SpringApplication.run(Application.class, args);
    }

}
