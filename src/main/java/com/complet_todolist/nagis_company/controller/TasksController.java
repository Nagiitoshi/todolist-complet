package com.complet_todolist.nagis_company.controller;

import com.complet_todolist.nagis_company.model.Tasks;
import com.complet_todolist.nagis_company.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@CrossOrigin(origins = "*")
public class TasksController {

    @Autowired
    private TasksService tasksService;

    @GetMapping
    public List<Tasks> getAllTasks(){
        return tasksService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Tasks getTaskById(@PathVariable Long id){
        return tasksService.getTaskById(id)
                .orElseThrow(() -> new RuntimeException("Task Not Found!!"));
    }

    @PostMapping
    public Tasks createTask(@RequestBody Tasks tasks){
        return tasksService.createTask(tasks);

    }

    @PutMapping("/{id}")
    public Tasks updateTask(@PathVariable Long id, @RequestBody Tasks tasks){
        return tasksService.updateTask(id,tasks);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        tasksService.deleteTask(id);
    }
}


