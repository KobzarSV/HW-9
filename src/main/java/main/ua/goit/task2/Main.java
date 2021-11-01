package main.ua.goit.task2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import static main.ua.goit.task2.UserUtils.checkIfFileAvailable;
import static main.ua.goit.task2.UserUtils.createList;


public class Main {
    private static final String PATCH_TXT = "src/main/resources/task2/file.txt";
    private static final String PATCH_JSON = "src/main/resources/task2/fileJson.json";

    public static void main(String[] args) {

        List<main.ua.goit.task2.User> users = new ArrayList<>();

        File file = new File(PATCH_TXT);
        createList(file, users);

        File jsonFile = new File(PATCH_JSON);
        checkIfFileAvailable(jsonFile);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(users);

        System.out.println(json);
    }
}
