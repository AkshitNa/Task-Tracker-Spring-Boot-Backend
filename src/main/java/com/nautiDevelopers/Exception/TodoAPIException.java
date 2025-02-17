package com.nautiDevelopers.Exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class TodoAPIException extends RuntimeException{
    private HttpStatus status;
    private String message;
}
