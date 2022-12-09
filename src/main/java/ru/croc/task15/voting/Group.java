package ru.croc.task15.voting;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private final int minAge;
    private int maxAge = -1;
    private final List<Respondent> respondents = new ArrayList<>();

    public Group(int minAge, int maxAge) {
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public void addRespondent(Respondent respondent) {
        if (minAge <= respondent.getAge() && respondent.getAge() <= maxAge) {
            respondents.add(respondent);
        }

        if (maxAge == -1 && respondent.getAge() >= minAge){
            respondents.add(respondent);
        }
    }

    public void sortGroup(){
        respondents.sort(Respondent::compareTo);
    }

    public Group(int minAge) {
        this.minAge = minAge;
    }

    @Override
    public String toString() {
        String age = (maxAge == -1) ? String.format("%s+", minAge) : String.format("%s-%s", minAge, maxAge);
        return String.format("%s: %s", age, respondents).replace("]", "").replace("[", "");
    }

    public boolean isEmpty() {
        return respondents.isEmpty();
    }
}
