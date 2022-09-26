package com.novruz.task.domain;

import lombok.Data;

@Data
public class Response<T> {
    private String errorMessage;
    private T data;

    public Response(String errorMessage) {
        data = null;
        this.errorMessage = errorMessage;
    }

    public Response(T data) {
        this.data = data;
        errorMessage = "no error.";
    }
}
