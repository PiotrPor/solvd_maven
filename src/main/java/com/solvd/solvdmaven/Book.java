package com.solvd.solvdmaven;

import com.solvd.solvdmaven.enums.LiteraturePieceType;
import com.solvd.solvdmaven.exceptions.WrongIsbnSetException;
import com.solvd.solvdmaven.exceptions.RemovingAuthorException;
import com.solvd.solvdmaven.enums.LiteratureGenre;

import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Book extends LiteraryPiece {
    private String author;
    private String isbn; //without letters "ISBN" at the beginning, only digits
    private Function<String,Boolean> testingIsbnLength;
    public static final String DEFAULT_ISBN = "0000000000000";
    private static final Logger LOGGER = LogManager.getLogger(Book.class);

    public Book() {
        super();
        theirType = LiteraturePieceType.BOOK;
        author = " ";
        isbn = DEFAULT_ISBN;
        testingIsbnLength = (givenISBN) -> {return (givenISBN.length() == 10 || givenISBN.length() == 13);};
    }

    public Book(String newTitle, String newPublish, String whenPublished, LiteratureGenre whatGenre, float newPrice, String itsAuthor, String isbnNumber) {
        super(newTitle, newPublish, whenPublished, whatGenre, newPrice);
        theirType = LiteraturePieceType.BOOK;
        author = itsAuthor;
        testingIsbnLength = (givenISBN) -> {return (givenISBN.length() == 10 || givenISBN.length() == 13);};
        if (testingIsbnLength.apply(isbnNumber)) {
            isbn = isbnNumber;
        } else {
            isbn = DEFAULT_ISBN;
        }
    }

    public void setAuthor(String newAuthor) throws RemovingAuthorException {
        try (ClassCheckingForStringContent cc = new ClassCheckingForStringContent(newAuthor)) {
            cc.checkIfBlank();
            author = newAuthor;
        } catch(RuntimeException e) {
            throw new RemovingAuthorException("Exception when changing author: "+ e.getMessage());
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setISBN(String newISBN) throws WrongIsbnSetException {
        if (testingIsbnLength.apply(newISBN)) {
            isbn = newISBN;
        } else {
            throw new WrongIsbnSetException("ISBN code must have either 10 or 13 digits");
        }
    }

    public String getISBN() {
        return isbn;
    }

    public void describeItself() {
        LOGGER.info(this.toString());
    }

    public static String getDefaultISBN() {
        return DEFAULT_ISBN;
    }

    @Override
    public String toString() {
        String thisAsString = "Book titled \"" + title + "\"\n";
        thisAsString += "Genre: " + genre.toString() + "\n";
        thisAsString += "Written by " + author + "\n";
        thisAsString += "Published by " + publisher + " on " + publishDate + "\n";
        thisAsString += "ISBN " + isbn + "\n";
        thisAsString += "Price: " + Float.toString(price) + " PLN\n";
        return thisAsString;
    }
}
