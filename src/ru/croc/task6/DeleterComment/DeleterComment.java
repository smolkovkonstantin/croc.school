package ru.croc.task6.DeleterComment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeleterComment {

    public static final Pattern START = Pattern.compile("/\\*");
    public static final Pattern END = Pattern.compile("\\*/");
    public static final Pattern DOUBLESLESH = Pattern.compile("//");

    private DeleterComment() {
    }

    // функция удаляет все полные /*..*/ в одной строке
    public static String deleteFullCommentAndSimple(StringBuilder str) {
        return deleteFullCommentAndSimple(str.toString());
    }

    public static String deleteFullCommentAndSimple(String str) {

        Matcher matcherStart = START.matcher(str);
        Matcher matcherEnd = END.matcher(str);

        int index = 0;

        StringBuilder result = new StringBuilder();

        while (matcherStart.find()) {
            result.append(str, index, matcherStart.start()); // срез до /*
            if (matcherEnd.find()) {
                index = matcherEnd.end();
            }
        }

        result.append(str.substring(index));
        return deleteSimpleComment(result);
    }

    public static String deleteSimpleComment(String str) {
        Matcher matcher = DOUBLESLESH.matcher(str);
        if (matcher.find()) {
            return str.substring(0, matcher.start());
        }
        return str;
    }

    public static String deleteSimpleComment(StringBuilder str) {
        return deleteSimpleComment(str.toString());
    }
}
