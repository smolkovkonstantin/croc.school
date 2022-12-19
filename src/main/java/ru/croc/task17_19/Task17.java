package ru.croc.task17_19;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.croc.reader.MyReader;
import ru.croc.task17_19.service.MainService;

import java.util.List;

@SpringBootApplication
public class Task17 {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Task17.class);

        MainService mainService = context.getBean(MainService.class);

        List<String[]> stringList = MyReader.readTask17(args[0]);

        stringList.forEach(mainService::registerOrderAndProduct);
    }
}
