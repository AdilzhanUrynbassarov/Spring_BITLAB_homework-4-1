package com.homework.homework41.controller;


import com.homework.homework41.model.Task;

import java.util.ArrayList;

public class DBManager {

    public static final ArrayList<Task> tasks = new ArrayList<Task>();

    public static Long id = 6l;
    static {
        tasks.add(new Task(1l, "Complete Task 7 from Spring Boot till the end of lesson", "2020-10-23", true));
        tasks.add(new Task(2l, "Clear home and buy foods", "2020-10-25", true));
        tasks.add(new Task(3l, "Complete all home tasks at the weekend", "2020-10-28", false));
        tasks.add(new Task(4l, "Develop simple project in Spring Boot for the final", "2020-12-12", false));
        tasks.add(new Task(5l, "Learn Italian Language", "2021-05-01", false));
    }


    public static ArrayList<Task> getTasks() {
        return tasks;
    }
    public static Task getTask(Long id){
        return tasks.stream().filter(items1 -> items1.getId() == id).findFirst().orElse(null);
    }
    public static void deleteTaskById(int id) {
        for (int i = 0; i < tasks.size(); i++) {
            if(tasks.get(i).getId() == id) {
                tasks.remove(i);
                break;
            }


        }
    }

    public static void updateTask(Task task) {
        for (int i = 0; i < tasks.size(); i++) {
            if(tasks.get(i).getId() == null) {
                tasks.set(i, task);
                break;
            }
        }
    }
    public static void addTask(Task task) {
        task.setId(id);
        tasks.add(task);
        id++;
    }
}
