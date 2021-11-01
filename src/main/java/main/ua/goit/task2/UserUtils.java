package main.ua.goit.task2;

import java.io.*;
import java.util.List;
import java.util.regex.Pattern;

public class UserUtils {

    public static void createList(File file, List<main.ua.goit.task2.User> list) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            String condition = "[a-zA-Z]+ [0-9]+";
            while ((line = reader.readLine()) != null) {
                String[] columns = line.trim().split(" ");
                if (Pattern.matches(condition, line)) {
                    main.ua.goit.task2.User user = new main.ua.goit.task2.User();
                    user.setName(columns[0]);
                    user.setAge(Integer.parseInt(columns[1]));
                    list.add(user);
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void checkIfFileAvailable(File file) {
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}



