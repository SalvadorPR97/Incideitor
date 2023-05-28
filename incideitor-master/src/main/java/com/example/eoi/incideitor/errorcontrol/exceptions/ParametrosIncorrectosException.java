package com.example.eoi.incideitor.errorcontrol.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class ParametrosIncorrectosException extends EntityNotFoundException {


    /**
     * Returns the detail message string of this throwable.
     *
     * @return the detail message string of this {@code Throwable} instance
     * (which may be {@code null}).
     */
    @Override
    public String getMessage() {

        return "Los parámetros son incorrectos";

    }


}
