package com.complet_todolist.nagis_company.service;

import com.complet_todolist.nagis_company.model.Tasks;
import com.complet_todolist.nagis_company.repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TasksService {

    @Autowired
    private TasksRepository tasksRepository;

    public List<Tasks> getAllTasks(){
        return tasksRepository.findAll();
    }

    public Optional<Tasks> getTaskById(Long id){
        return tasksRepository.findById(id);
    }

    public Tasks createTask(Tasks tasks){
        return tasksRepository.save(tasks);
    }

    public Tasks updateTask(Long id, Tasks updateTasks){
        updateTasks.setId(id);

        return tasksRepository.save(updateTasks);
    }

    public void deleteTask(Long id){
        tasksRepository.deleteById(id);
    }
}

