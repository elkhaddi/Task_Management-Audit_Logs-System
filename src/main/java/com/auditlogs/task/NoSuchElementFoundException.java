package com.auditlogs.task;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class NoSuchElementFoundException extends RuntimeException{
    public NoSuchElementFoundException(String message) {
        super(message);
    }
}
