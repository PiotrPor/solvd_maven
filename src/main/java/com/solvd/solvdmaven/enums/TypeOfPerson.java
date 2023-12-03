package com.solvd.solvdmaven.enums;

public enum TypeOfPerson {
    CLIENT("Client"),
    EMPLOYEE("Employee"),
    OTHER("Other");

    private final String nameOfType;

    TypeOfPerson(String name) {
        nameOfType = name;
    }

    @Override
    public String toString() {
        return nameOfType;
    }
}
