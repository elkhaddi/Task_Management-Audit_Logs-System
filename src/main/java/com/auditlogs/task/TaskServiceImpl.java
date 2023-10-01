package com.auditlogs.task;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {

        return taskRepository.save(task);
    }
    @Override
    public Task updateTask(Long id, Task task){
        Optional<Task> temp = taskRepository.findById(id);
        if(temp.isEmpty()){
            throw new NoSuchElementFoundException("No task found with id = "+id);
        }
        task.setId(id);
        return taskRepository.save(task);
    }

    @Override
    public String deleteTask(Long id) {
        Optional<Task> temp = taskRepository.findById(id);
        if(temp.isEmpty()){
            throw new NoSuchElementFoundException("No task found with id = "+id);
        }
        taskRepository.deleteById(id);
        return "task has been successfully deleted.";
    }

    @Override
    public Task getTask(Long id) {
        Optional<Task> temp = taskRepository.findById(id);
        if(temp.isEmpty()){
            throw new NoSuchElementFoundException("No task found with id = "+id);
        }
        return temp.get();
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}
