package com.lab.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ObjectNotFoundException extends Throwable {

    public ObjectNotFoundException(String msg) {
        super(msg);
    }
}
