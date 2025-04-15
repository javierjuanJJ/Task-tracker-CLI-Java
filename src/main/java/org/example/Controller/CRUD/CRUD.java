package org.example.Controller.CRUD;

import org.example.Controller.UtilMethods.UtilMethods;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

public class CRUD {
    public static boolean addTask(String description) throws IOException, ParseException {
        JSONArray tasks = UtilMethods.readTasksFromFile();

        JSONObject newTask = new JSONObject();
        newTask.put("id", UtilMethods.getNextId(tasks));
        newTask.put("description", description);
        newTask.put("createdAt", new Date());
        newTask.put("updatedAt", new Date());
        newTask.put("status", "todo");

        tasks.put(newTask);

        UtilMethods.writeTasksToFile(tasks);
        return true;
    }

    public static boolean updateTask(int id, String newDescription) throws IOException, ParseException {
        JSONArray tasks = UtilMethods.readTasksFromFile();
        boolean found = false;

        for (int i = 0; i < tasks.length(); i++) {
            JSONObject task = (JSONObject) tasks.get(i);
            int taskId = task.getInt("id");

            if (taskId == id) {
                task.put("description", newDescription);
                task.put("updatedAt", new Date());
                found = true;
                break;
            }
        }

        if (found) {
            UtilMethods.writeTasksToFile(tasks);
            return true;
        } else {
            throw new IOException("Error: No se encontró ninguna tarea con ID " + id);
        }
    }

    public static boolean deleteTask(int id) throws IOException, ParseException {
        JSONArray tasks = UtilMethods.readTasksFromFile();
        boolean found = false;

        for (int i = 0; i < tasks.length(); i++) {
            JSONObject task = (JSONObject) tasks.get(i);
            int taskId = task.getInt("id");

            if (taskId == id) {
                tasks.remove(i);
                found = true;
                break;
            }
        }

        if (found) {
            UtilMethods.writeTasksToFile(tasks);
            return true;
        } else {
            throw new IOException("Error: No se encontró ninguna tarea con ID " + id);
        }
    }

    public static boolean markTaskStatus(int id, String status) throws IOException, ParseException {
        JSONArray tasks = UtilMethods.readTasksFromFile();
        boolean found = false;

        for (int i = 0; i < tasks.length(); i++) {
            JSONObject task = (JSONObject) tasks.get(i);
            int taskId = task.getInt("id");

            if (taskId == id) {
                task.put("status", status);
                found = true;
                break;
            }
        }

        if (found) {
            UtilMethods.writeTasksToFile(tasks);
            return true;
        } else {
            throw new IOException("Error: No se encontró ninguna tarea con ID " + id);
        }
    }

    public static String listTasks(String filter) throws Exception {
        JSONArray tasks = UtilMethods.readTasksFromFile();

        if (tasks.isEmpty()) {
            throw new Exception("No hay tareas registradas");
        }
        StringBuilder sb = new StringBuilder();

        sb.append("Lista de tareas:\n----------------");

        for (Object obj : tasks) {
            JSONObject task = (JSONObject) obj;
            String taskStatus = (String) task.get("status");

            if (filter == null || filter.equals(taskStatus)) {
                String description = (String) task.get("description");
                sb.append("ID: ")
                        .append(task.get("id"))
                        .append(" | Descripción: ")
                        .append(description)
                        .append(" | Estado: ")
                        .append(taskStatus)
                        .append(" | Creado: ")
                        .append(task.get("createdAt"))
                        .append(" | Actualizado: ")
                        .append(task.get("updatedAt"));
            }

        }
        return sb.toString();
    }
}
