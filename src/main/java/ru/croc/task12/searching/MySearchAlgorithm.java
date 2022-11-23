package ru.croc.task12.searching;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс находит подстроку в строке,
 * при этом в подстроке может не совпадать 1 символ
 */

public class MySearchAlgorithm implements SearchAlgorithms {

    @Override
    public int find(String subString, String string) {

        if (alwaysFalse(subString, string)) {
            return -1;
        }

        Matcher matcher;

        for (int i = 0; i < subString.length(); i++) {

            String regex = (subString.length() > 1) ?
                    subString.substring(0, i) + "." + subString.substring(i + 1) :
                    subString;

            matcher = Pattern.compile(regex).
                    matcher(string);
            if (matcher.find()) {
                if (matcher.end() < string.length() &&
                        (String.valueOf(string.charAt(matcher.start())).matches("\\W") ||
                                String.valueOf(string.charAt(matcher.end())).matches("\\W"))) {
                    return matcher.start();
                }
                else{
                    if (matcher.end() == string.length()){
                        return matcher.start();
                    }
                }
            }
        }
        return -1;
    }

    public String replaceAllBadWord(String subString, String string) {
        int index = find(subString, string);
        while (index != -1) {
            string = string.replace(
                    string.substring(index, index + subString.length()),
                    new String(new char[subString.length()]).replace('\0', '*')
            );
            index = find(subString, string);
        }
        return string;
    }

    public String replaceAllBadWord(Set<String> subStrings, String string) {
        for (String subString : subStrings) {
            string = replaceAllBadWord(subString, string);
        }
        return string;
    }
}
