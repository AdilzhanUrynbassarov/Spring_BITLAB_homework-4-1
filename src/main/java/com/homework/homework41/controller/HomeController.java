package com.homework.homework41.controller;

import com.homework.homework41.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String indexPage(Model model) {
        ArrayList<Task> tasks = DBManager.getTasks();
        model.addAttribute("tasky", tasks);
        return "index";
    }
    @GetMapping(value = "/task-details")
    public String getTask(@RequestParam(name = "taskId") Long id,
                         Model model ) {
        Task task = DBManager.getTask(id);
        model.addAttribute("detail", task);
        return "details";

    }

    @GetMapping(value = "/details/{taskId}")
    public String taskDetails(@PathVariable(name = "taskId") Long id, Model model) {
        Task task = DBManager.getTask(id);
        model.addAttribute("tasky", task);
        return "details";
    }
    @PostMapping(value = "/save-task" )
    public String saveTask(
            @RequestParam(name = "taskId") Long id,
            @RequestParam(name = "name") String name,
            @RequestParam(name ="deadlineDate") String deadlineDate,
            @RequestParam(name = "completed") boolean completed
            ) {

        Task task = DBManager.getTask(id);
        task.setName(name);
        task.setDeadlineDate(deadlineDate);
        task.setCompleted(completed);
        DBManager.updateTask(task);
        return "redirect:/";
    }

    @PostMapping(value = "/delete-task")
    public String deleteTask(@RequestParam(name = "taskId") int id) {
        DBManager.deleteTaskById(id);
        return "redirect:/";

    }

    @PostMapping(value = "/add-task")
    public String addTask(Task task) {
        DBManager.addTask(task);
        return "addTask";
    }
    @GetMapping(value = "/add-task")
    public String addTaskPage(Model model) {
        return "addTask";
    }


}
