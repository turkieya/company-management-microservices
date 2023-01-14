package com.example.assignmentservice.services;

import com.example.assignmentservice.entities.Assignment;
import com.example.assignmentservice.entities.Task;
import com.example.assignmentservice.repositories.AssignmentRepository;
import com.example.assignmentservice.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    @Autowired
    AssignmentRepository assignmentRepository;

    public Task saveTask(Task task ,long idAss) {
        Assignment assignment = assignmentRepository.findById(idAss).get();
        task.setAssignment(assignment);
        taskRepository.save(task);

        return task;
    }

    @Transactional
    public void editTask(@RequestBody Task task) {
        taskRepository.edit(task.getId(),task.getDescription(),task.getStatus(),task.getStart_date(),task.getEnd_date());
    }
    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }

    public Optional<Task> getTaskById(Long id)
    {   return taskRepository.findById(id);
    }
}
