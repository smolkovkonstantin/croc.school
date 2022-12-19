package ru.croc.task17;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.croc.reader.MyReader;
import ru.croc.task17.service.MainService;

@SpringBootApplication
public class Task17 {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Task17.class);

        MainService mainService = context.getBean(MainService.class);

        MyReader.readTask17(args[0]).forEach(mainService::registerOrderAndProduct);

    }
}
