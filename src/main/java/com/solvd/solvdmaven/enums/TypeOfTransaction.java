package com.solvd.solvdmaven.enums;

public enum TypeOfTransaction {
    SALE("Sale"),
    LEASE("Lease"),
    OTHER("Other");

    private final String transTypeName;

    TypeOfTransaction(String name) {
        transTypeName = name;
    }

    @Override
    public String toString() {
        return transTypeName;
    }
}
