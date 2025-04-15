package org.example.Controller.UtilMethods;

import org.example.Main;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UtilMethods {
    private static final String JSON_FILE = "tasks.json";

    public static int stringToInt(String input) throws NumberFormatException {
        return Integer.parseInt(input);
    }

    public static JSONArray readTasksFromFile() throws IOException, JSONException {
        File file = new File(JSON_FILE);

        if (file.exists()) {
            String content = new String(Files.readAllBytes(Paths.get(JSON_FILE)));
            if (!content.isEmpty()) {
                return new JSONArray(content);
            }
        }

        return new JSONArray();
    }

    public static void writeTasksToFile(JSONArray tasks) throws IOException {
        try (FileWriter writer = new FileWriter(JSON_FILE)) {
            writer.write(tasks.toString(2)); // Pretty print con indentación de 2 espacios
            writer.flush();
        }
    }

    public static int getNextId(JSONArray tasks) {
        int maxId = 0;

        for (Object obj : tasks) {
            JSONObject task = (JSONObject) obj;
            int id = task.getInt("id");
            maxId = Math.max(maxId, id);
        }

        return maxId + 1;
    }
}
