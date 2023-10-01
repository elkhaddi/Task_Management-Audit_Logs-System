# Project Name:
Task Management Audit Log System

# Project Description: 
The Task Management Audit Log System is designed to record and monitor all activities related to task management within the application. It uses Spring Boot AOP to intercept and log specific actions and changes to application.log file.

# Key features:
Task Creation and Updates: Log when tasks are created, modified, or deleted, along with details of the changes made.

# Technologies Used:
Spring Boot: For building the application and AOP configuration.
Spring Data JPA with H2: For interacting with the database.
slf4j logging library with lombok configuration: to perform Logging Aspect (cross-cutting concern).
