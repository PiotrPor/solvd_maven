package com.solvd.solvdmaven.exceptions;

public class WrongIsbnSetException extends Exception {
    public WrongIsbnSetException() {
        super();
    }

    public WrongIsbnSetException(String msg) {
        super(msg);
    }
}
