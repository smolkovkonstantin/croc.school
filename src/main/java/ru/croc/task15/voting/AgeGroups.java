package ru.croc.task15.voting;

import java.util.ArrayList;
import java.util.List;

public class AgeGroups {

    final List<Group> groups = new ArrayList<>();

    public AgeGroups(String[] ages) {

        groups.add(new Group(
                Integer.parseInt(ages[ages.length - 1]) + 1)
        );

        for (int i = ages.length - 1; i >= 1; i--) {
            groups.add(new Group(
                    Integer.parseInt(ages[i - 1]) + 1,
                    Integer.parseInt(ages[i])
            ));
        }

        groups.add(new Group(
                0,
                Integer.parseInt(ages[0]))
        );
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
