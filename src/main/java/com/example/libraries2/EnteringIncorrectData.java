package com.example.libraries2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EnteringIncorrectData extends RuntimeException {
    public EnteringIncorrectData(String message) {
        super(message);
    }
}
