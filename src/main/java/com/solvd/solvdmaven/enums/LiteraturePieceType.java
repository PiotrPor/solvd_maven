package com.solvd.solvdmaven.enums;

public enum LiteraturePieceType {
    BOOK("Book"),
    MAGAZINE("Magazine"),
    OTHER("Other");

    private final String nameOfType;

    LiteraturePieceType(String typeName) {
        nameOfType = typeName;
    }

    @Override
    public String toString() {
        return nameOfType;
    }
}
