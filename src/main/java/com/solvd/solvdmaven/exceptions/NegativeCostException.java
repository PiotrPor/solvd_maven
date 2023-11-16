package com.solvd.solvdmaven.exceptions;

public class NegativeCostException extends Exception {
    public NegativeCostException() {
        super();
    }

    public NegativeCostException(String msg) {
        super(msg);
    }
}
