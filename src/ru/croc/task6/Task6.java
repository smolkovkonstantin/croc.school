package ru.croc.task6;

import ru.croc.task6.DeleterComment.DeleterComment;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.regex.Matcher;


public class Task6 {
    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile(".\\src\\ru\\croc\\task6\\DeleterComment\\Test.java", "r")) {

            Matcher matcher;
            String str;
            StringBuilder result = new StringBuilder();

            while ((str = file.readLine()) != null) {

                // обработка всех /*...*/ в одной строке и "//"
                str = DeleterComment.deleteFullCommentAndSimple(str);

                // если комментарий есть ещё один комментарий в этой строке, то заканчивается он на следующей
                // добавляю все строки, в которых содержатся концы комментария
                matcher = DeleterComment.START.matcher(str);
                if (matcher.find()) {
                    StringBuilder allLinesWithComment = new StringBuilder(str);
                    while ((str = file.readLine()) != null) {
                        allLinesWithComment.append(str);
                        matcher = DeleterComment.END.matcher(str);
                        if (matcher.find()){
                            break;
                        }
                    }
                    // удаляю возможные комментарии /*..*/ и "//"
                    result.append(DeleterComment.deleteFullCommentAndSimple(allLinesWithComment)).append("\n");
                } else {
                    result.append(str).append("\n");
                }
            }
            System.out.println(result);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
