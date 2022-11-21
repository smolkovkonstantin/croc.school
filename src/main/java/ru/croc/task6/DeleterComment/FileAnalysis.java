package ru.croc.task6.DeleterComment;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.regex.Matcher;

public class FileAnalysis {

    private String nameFile;
    private final StringBuilder result = new StringBuilder();

    public FileAnalysis(String nameFile) {
        this.nameFile = nameFile;
    }

    public void start() {
        try (RandomAccessFile file = new RandomAccessFile(nameFile, "r")) {
            lineByLine(file);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void lineByLine(RandomAccessFile file) throws IOException {

        Matcher matcher;
        String str;

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
                    if (matcher.find()) {
                        break;
                    }
                }
                // удаляю возможные комментарии /*..*/ и "//"
                result.append(DeleterComment.deleteFullCommentAndSimple(allLinesWithComment)).append("\n");
            } else {
                result.append(str).append("\n");
            }
        }
    }


    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public StringBuilder getResult() {
        return result;
    }
}
