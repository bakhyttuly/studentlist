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

}
