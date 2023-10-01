package com.auditlogs.task;

import java.util.List;

public interface TaskService {
    Task createTask(Task task);
    Task updateTask(Long id,Task task);
    String deleteTask(Long id);
    Task getTask(Long id);
    List<Task> getAllTasks();
}
