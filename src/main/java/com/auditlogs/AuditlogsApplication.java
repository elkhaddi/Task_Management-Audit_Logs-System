package com.auditlogs;

import com.auditlogs.task.Task;
import com.auditlogs.task.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class AuditlogsApplication implements CommandLineRunner {
    private final TaskRepository taskRepository;

    public static void main(String[] args) {
        SpringApplication.run(AuditlogsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Task> tasks = Arrays.asList(
                new Task("Finish project report","Complete the final draft of the project report.",true),
                new Task("Exercise","Go for a 30-minute jog in the park.",false),
                new Task("Read a book","Read the latest novel for 1 hour.",false),
                new Task("Pay bills","Pay utility bills and rent.",true)

        );
        taskRepository.saveAll(tasks);
    }
}
