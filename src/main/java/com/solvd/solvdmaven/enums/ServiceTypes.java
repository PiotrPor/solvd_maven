package com.solvd.solvdmaven.enums;

public enum ServiceTypes {
    BEAUTY("Beauty Studio"),
    LIBRARY("Library"),
    OTHER("Other");

    private final String serviceType;

    ServiceTypes(String name) {
        serviceType = name;
    }

    @Override
    public String toString() {
        return serviceType;
    }
}
