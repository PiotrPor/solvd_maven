package com.solvd.solvdmaven;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class ClassCheckingForStringContent implements AutoCloseable {
    public String investigatedString;
    private static final Logger LOGGER = LogManager.getLogger(ClassCheckingForStringContent.class);

    public ClassCheckingForStringContent() {
        investigatedString = "";
    }

    public ClassCheckingForStringContent(String s) {
        investigatedString = s;
    }

    public void checkIfBlank() throws RuntimeException {
        if (investigatedString.isEmpty() || investigatedString.equals(" ")) {
            throw new RuntimeException("The string to be set is blank or empty");
        } else {
            // do nothing
        }
    }

    @Override
    public void close() {
        LOGGER.info("Object used for checking a string is closing");
    }
}
