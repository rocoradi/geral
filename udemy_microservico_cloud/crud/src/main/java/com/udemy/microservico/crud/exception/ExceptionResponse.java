package com.udemy.microservico.crud.exception;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExceptionResponse implements Serializable {

    private LocalDateTime data;
    private String message;
    private String details;
}
