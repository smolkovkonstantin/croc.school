package ru.croc.task15.voting;

import java.util.ArrayList;
import java.util.List;

public class AgeGroups {

    final List<Group> groups = new ArrayList<>();

    public AgeGroups(String[] ages) {
        for (int i = ages.length - 1; i >= 0; i--) {
            if (i == 0) {
                groups.add(new Group(
                        0,
                        Integer.parseInt(ages[i]))
                );
            } else if (i == ages.length - 1) {
                groups.add(new Group(
                        Integer.parseInt(ages[i]) + 1)
                );
            } else if (i == ages.length - 2) {
                groups.add(new Group(
                        Integer.parseInt(ages[i]) + 1,
                        Integer.parseInt(ages[i + 1])
                ));
            } else {
                groups.add(new Group(
                        Integer.parseInt(ages[i - 1]) + 1,
                        Integer.parseInt(ages[i])
                ));
            }
        }
    }

    public void distribution(List<Respondent> allRespondent) {
        allRespondent.forEach((respondent) ->
                groups.forEach((group) -> group.addRespondent(respondent))
        );
    }

    @Override
    public String toString() {
        return groups.toString();
    }

    public List<Group> getGroups() {
        return groups;
    }
}
