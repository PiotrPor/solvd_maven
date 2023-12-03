package com.solvd.solvdmaven.enums;

public enum LiteratureGenre {
    HISTORY("History"),
    BIOGRAPHY("Biography"),
    TECH("Technology"),
    CRIME("Crime"),
    ROMANCE("Romance"),
    ACTION("Action"),
    SCIFI("Science-Fiction"),
    HORROR("Horror"),
    FAIRYTALE("Fairytale"),
    ADVENTURE("Adventure"),
    OTHER("Other");

    private final String genreName;

    LiteratureGenre(String name) {
        this.genreName = name;
    }

    @Override
    public String toString() {
        return genreName;
    }
}
