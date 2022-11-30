package ru.croc.task15.voting;

import java.util.Comparator;

public class Respondent implements Comparator<Respondent> {

    private final String fullName;
    private final int age;

    public Respondent(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    protected int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", fullName, age);
    }


    @Override
    public int compare(Respondent o1, Respondent o2) {
        if (o1.age == o2.age) {
            return o1.fullName.compareTo(o2.fullName);
        } else {
            return -1 * Integer.compare(o1.age, o2.age);
        }
    }
}
