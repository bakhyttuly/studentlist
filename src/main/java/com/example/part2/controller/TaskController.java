package com.example.part2.controller;

import com.example.part2.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class TaskController {

    private List<Task> tasks = new ArrayList<>();
    private Long counter = 1L;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tasks", tasks);
        return "index";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("task", new Task());
        return "add";
    }

    @PostMapping("/add")
    public String addTask(@ModelAttribute Task task) {
        task.setId(counter++);
        tasks.add(task);
        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {
        Optional<Task> task = tasks.stream().filter(t -> t.getId().equals(id)).findFirst();
        task.ifPresent(value -> model.addAttribute("task", value));
        return "details";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Optional<Task> task = tasks.stream().filter(t -> t.getId().equals(id)).findFirst();
        task.ifPresent(value -> model.addAttribute("task", value));
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String editTask(@PathVariable Long id, @ModelAttribute Task updatedTask) {
        tasks.removeIf(t -> t.getId().equals(id));
        updatedTask.setId(id);
        tasks.add(updatedTask);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        tasks.removeIf(t -> t.getId().equals(id));
        return "redirect:/";
    }
}
