package kz.storelink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StorelinkApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorelinkApplication.class, args);
    }

    @GetMapping
    public String testFunction() {
        return "Mukhtar KOTAKBAS!!!!";
    }

}
