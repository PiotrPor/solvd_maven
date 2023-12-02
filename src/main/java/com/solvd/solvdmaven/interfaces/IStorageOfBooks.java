package com.solvd.solvdmaven.interfaces;

import com.solvd.solvdmaven.Book;
import com.solvd.solvdmaven.enums.LiteratureGenre;

import java.util.List;

public interface IStorageOfBooks {
    List<Book> searchForBooksByTitle(String searchedTitle);
    List<Book> searchForBooksByGenre(LiteratureGenre searchedGenre);
}
