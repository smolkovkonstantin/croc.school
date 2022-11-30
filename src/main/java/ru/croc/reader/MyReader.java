package ru.croc.reader;

import ru.croc.task13.cinema.Films;
import ru.croc.task13.cinema.InformationUser;
import ru.croc.task15.voting.Respondent;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyReader {
    private MyReader() {
    }

    public static String[] readTask9(String[] args) {
        if (args.length > 0) {
            return args;
        } else {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine().split(" ");
        }
    }

    public static Films readTask13(String path) {

        Films films = new Films();

        try (Reader reader = new FileReader(path)) {
            Scanner scanner = new Scanner(reader);

            while (scanner.hasNext()) {
                films.add(scanner.nextLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return films;
    }

    public static InformationUser readTask13User(String path) {

        InformationUser informationUser = new InformationUser();

        try (Reader reader = new FileReader(path)) {
            Scanner scanner = new Scanner(reader);

            while (scanner.hasNext()) {
                informationUser.add(scanner.nextLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return informationUser;
    }

    public static List<Respondent> readTask15(String path) {

        List<Respondent> respondents = new ArrayList<>();

        try (Reader reader = new FileReader(path)) {
            Scanner scanner = new Scanner(reader);

            String current;

            while (!(current = scanner.nextLine()).equalsIgnoreCase("END")) {
                String[] fullNameAndAge = current.split(",");

                respondents.add(new Respondent(fullNameAndAge[0], Integer.parseInt(fullNameAndAge[1])));

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return respondents;
    }

}
