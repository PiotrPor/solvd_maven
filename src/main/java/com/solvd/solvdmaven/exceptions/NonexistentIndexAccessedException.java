package com.solvd.solvdmaven.exceptions;

public class NonexistentIndexAccessedException extends RuntimeException {
    public NonexistentIndexAccessedException() {
        super();
    }

    public NonexistentIndexAccessedException(String msg) {
        super(msg);
    }
}
