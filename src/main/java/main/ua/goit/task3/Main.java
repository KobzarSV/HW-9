package main.ua.goit.task3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Main {
    private static final String WORDS = "src/main/resources/task3/words.txt";

    public static void main(String[] args) {

        File file = new File(WORDS);

        HashMap<String, Integer> mapWords = new HashMap<>();

        identicalWordCounter(file, mapWords);

        for (Map.Entry entry : mapWords.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private static void identicalWordCounter(File file, Map<String, Integer> map) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            String condition = "[a-z]+";
            while ((line = reader.readLine()) != null) {

                String[] w = line.trim().split(" ");

                for (int i = 0; i < w.length; i++) {
                    if (Pattern.matches(condition, w[i])) {
                        if (map.containsKey(w[i])) {
                            map.put(w[i], map.get(w[i]) + 1);
                        } else map.put(w[i], 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
