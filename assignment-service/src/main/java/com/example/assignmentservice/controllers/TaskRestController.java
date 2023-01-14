package com.example.assignmentservice.controllers;

import com.example.assignmentservice.entities.Status;
import com.example.assignmentservice.entities.Task;
import com.example.assignmentservice.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskRestController {

    @Autowired
    TaskService taskService;

    @PreAuthorize("hasAuthority('chef_equipe')")
    @PostMapping(path="/add/{idAss}")
    public Task addTask(@RequestBody Task task,@PathVariable long idAss) {
        return taskService.saveTask(task,idAss) ;
    }

    @GetMapping(path = "/status")
    public List getStatus(){
        List<Status> status =new ArrayList<Status>();
        status.add(Status.PENDING);
        status.add(Status.COMPLETED);
        status.add(Status.CANCELED);
        return status;
    }

    @PutMapping(path="/edit")
    public void editTask(@RequestBody Task task){
        taskService.editTask(task);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteTask (@PathVariable Long id){
        taskService.deleteTaskById(id);
    }
    @GetMapping(path = "/get/{id}")
    public Optional<Task> getTask(@PathVariable long id) {
        return taskService.getTaskById(id) ;

    }
}
