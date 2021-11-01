package main.ua.goit.task1;

import java.io.*;
import java.util.regex.Pattern;

public class PhoneNumberFile {
    public static void main(String[] args) {
        String phoneNumbers = "src/main/resources/task1/file.txt";
        File file = new File(phoneNumbers);
        String condition1 = "\\d{3}-\\d{3}-\\d{4}$";
        String condition2 = "\\(\\d{3}\\)\\s\\d{3}-\\d{4}$";

        if (!file.exists()) {
            throw new RuntimeException("File with name " + file.getName() + " not exists");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(phoneNumbers))) {
            String line = reader.readLine();
            while (line != null) {
                if (Pattern.matches(condition1, line) || Pattern.matches(condition2, line)) {
                    System.out.println(line);
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
