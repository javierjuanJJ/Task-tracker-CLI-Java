package org.example;

import org.example.Controller.CRUD.CRUD;
import org.example.Controller.UtilMethods.UtilMethods;

public class Main {

    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                throw new Exception("Error: Se requiere un comando. Opciones: add, update, delete, mark-in-progress, mark-done, list");
            }

            String command = args[0];

            int id = 0;
            switch (command) {
                case "add":
                    if (args.length != 2) {
                        throw new Exception("Error: El comando 'add' requiere un parámetro: descripción de la tarea");
                    }
                    if (CRUD.addTask(args[1])) {
                        System.out.println("Task added successfully (ID: " +
                                (UtilMethods.getNextId(UtilMethods.readTasksFromFile()) - 1) +
                                ")");
                    }
                    break;
                case "update":
                    if (args.length != 3) {
                        throw new Exception("Error: El comando 'update' requiere dos parámetros: ID y nueva descripción");
                    }
                    id = UtilMethods.stringToInt(args[1]);
                    if (CRUD.updateTask(id, args[2])) {
                        System.out.println("Tarea con ID " + id + " actualizada correctamente");
                    }
                    break;
                case "delete":
                    if (args.length != 2) {
                        throw new Exception("Error: El comando 'delete' requiere un parámetro: ID");
                    }

                    id = UtilMethods.stringToInt(args[1]);

                    if (CRUD.deleteTask(id)) {
                        System.out.println("Tarea con ID " + id + " eliminada correctamente");
                    }
                    break;
                case "mark-in-progress":
                    if (args.length != 2) {
                        throw new Exception("Error: El comando 'mark-in-progress' requiere un parámetro: ID");
                    }

                    id = UtilMethods.stringToInt(args[1]);

                    if (CRUD.markTaskStatus(id, "in-progress")) {
                        System.out.println("Tarea con ID " + id + " marcada como '" + "progress" + "' correctamente");
                    }

                    break;
                case "mark-done":
                    if (args.length != 2) {
                        throw new Exception("Error: El comando 'mark-done' requiere un parámetro: ID");
                    }
                    id = UtilMethods.stringToInt(args[1]);
                    if ( CRUD.markTaskStatus(id, "done")) {
                        System.out.println("Tarea con ID " + id + " marcada como '" + "done" + "' correctamente");
                    }

                    break;
                case "list":
                    if (args.length > 2) {
                        throw new Exception("Error: El comando 'list' puede ir sin parámetros o con un filtro: done, todo, in-progress");
                    }

                    String filter = args.length == 2 ? args[1] : null;

                    if (filter != null && !filter.equals("done") && !filter.equals("todo") && !filter.equals("in-progress")) {
                        throw new Exception("El filtro debe ser uno de: done, todo, in-progress");
                    }

                    System.out.println(CRUD.listTasks(filter));
                    break;
                default:
                    throw new Exception("Error: Comando desconocido. Opciones: add, update, delete, mark-in-progress, mark-done, list");
            }
        } catch (NumberFormatException e) {
            System.err.println("Error: The input string is not a valid integer.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}