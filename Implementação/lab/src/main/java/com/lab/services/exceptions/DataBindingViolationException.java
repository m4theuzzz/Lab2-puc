package com.lab.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FAILED_DEPENDENCY)
public class DataBindingViolationException extends Throwable {

    public DataBindingViolationException(String message) {
        super(message);
    }

}
