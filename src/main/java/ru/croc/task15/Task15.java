package ru.croc.task15;

import ru.croc.reader.MyReader;
import ru.croc.task15.voting.AgeGroups;
import ru.croc.task15.voting.Group;
import ru.croc.task15.voting.Respondent;

import java.util.List;

public class Task15 {
    public static void main(String[] args) {
        List<Respondent> respondents = MyReader.readTask15(".\\src\\main\\java\\ru\\croc\\task15\\test.txt");

        AgeGroups ageGroups = new AgeGroups(args);

        ageGroups.distribution(respondents);

        ageGroups.getGroups().forEach(Group::sortGroup);

        ageGroups.getGroups().forEach(group -> {
            if (!group.isEmpty()) {
                System.out.println(group);
            }
        });
    }
}
