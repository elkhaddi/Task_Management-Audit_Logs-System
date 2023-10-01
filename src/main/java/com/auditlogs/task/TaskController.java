package com.auditlogs.task;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping(value = "/task")
    public ResponseEntity<Task> createTask(@RequestBody Task taskRequest){
        Task task = taskService.createTask(taskRequest);
        return new ResponseEntity<>(task,HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable(name = "id") Long id,@RequestBody Task taskRequest){
        Task task = taskService.updateTask(id,taskRequest);
        return new ResponseEntity<>(task,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id){
        String result = taskService.deleteTask(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id){
        Task task = taskService.getTask(id);
        return ResponseEntity.ok(task);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Task>> getAllTasks(){
        return new ResponseEntity<>(taskService.getAllTasks(),HttpStatus.OK);
    }
}
