package com.br.logistic.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Error {
    private Integer status;
    private String title;
    private LocalDateTime errorAt;
    private List<Field> fields;

    @AllArgsConstructor
    @Getter
    public static class Field {
        private String name;
        private String message;
    }
}
