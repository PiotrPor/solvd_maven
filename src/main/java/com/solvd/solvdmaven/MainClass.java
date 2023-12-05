package com.solvd.solvdmaven;

import com.solvd.solvdmaven.exceptions.*;
import com.solvd.solvdmaven.enums.LiteratureGenre;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
Among the files in this package
  "MainClass.java" contains the main()
  13 files are classes
  5 files are interfaces
  5 files are custom exceptions
  5 files are enumerators
*/

public class MainClass {
    static {
        System.setProperty("log4j.configurationFile", "log4j.xml");
    }

    private static final Logger LOGGER = LogManager.getLogger(MainClass.class);

    public static void main(String[] args) {
        LOGGER.info("##\n##\nStarting anew\n##\n##");
        LOGGER.info("main() starts running");
        List<Employee> employeesForLibrary = new ArrayList<>();
        List<Book> booksForLibrary = new ArrayList<>();
        List<Magazine> magazinesForLibrary = new ArrayList<>();

        //----------

        employeesForLibrary.add(new Employee("Jane", "Bookqueen", 1, 4000f));
        employeesForLibrary.add(new Employee("Margarett", "Paperlady", 2, 3900f));

        //----------

        booksForLibrary.add(new Book(
                "The ABC murders",
                "Wydawnictwo Dolnoslaskie",
                "14.05.2013",
                LiteratureGenre.CRIME,
                14.99f,
                "Agatha Christie",
                "9788327153999"));
        booksForLibrary.add(new Book(
                "Historia pracy. Nowe dzieje ludzkosci",
                "Horyzont Znak",
                "2023",
                LiteratureGenre.HISTORY,
                88.39f,
                "Jan Lucassen",
                "9788324088713"));
        Book thirdBook = new Book();
        boolean thereWasAnException = false;
        try {
            thirdBook.setTitle("Felix, Net i Nika oraz Trzecia Kuzynka");
            thirdBook.publisher = "Powergraph";
            thirdBook.publishDate = "01.11.2009";
            thirdBook.setGenre(LiteratureGenre.ADVENTURE);
            thirdBook.setPrice(21.5f); //NegativeCostException
            thirdBook.setAuthor("Rafal Kosik"); //RemovingAuthorException
            thirdBook.setISBN("9788361187127"); //WrongIsbnSetException
        } catch(RemovingTitleException | RemovingAuthorException e1) {
            thereWasAnException = true;
            LOGGER.warn(e1.getMessage());
        } catch(NegativeCostException | WrongIsbnSetException e2) {
            thereWasAnException = true;
            LOGGER.warn("Exception: "+ e2.getMessage());
        } catch(Exception e3) {
            thereWasAnException = true;
            LOGGER.warn("Noncustom exception when adding book: "+ e3.getMessage());
        }

        if (!thereWasAnException) {
            booksForLibrary.add(thirdBook);
        }

        //----------

        magazinesForLibrary.add(new Magazine(
                "PC Format",
                "Fantasyexpo",
                "01.03.2021",
                LiteratureGenre.TECH,
                9.5f,
                247));
        magazinesForLibrary.add(new Magazine(
                "CD-Action",
                "Fantasyexpo",
                "01.04.2022",
                LiteratureGenre.OTHER,
                34.5f,
                312));

        //-------------------

        Client firstClient = new Client("Andrew", "Bookeater", 2, LiteratureGenre.CRIME);
        Client secondClient = new Client("John","Kowalsky",3,LiteratureGenre.SCIFI);

        //-------------------

        int i;
        Library onlyLibrary = new Library();

        employeesForLibrary.forEach(em -> onlyLibrary.addEmployeeToList(em));
        booksForLibrary.forEach(b -> onlyLibrary.addBookToList(b));
        magazinesForLibrary.forEach(m -> onlyLibrary.addMagazineToList(m));

        //---------------------
        LOGGER.info("\n===================\n");

        List<Book> booksForHim = onlyLibrary.searchForBooksByGenre(firstClient.getFavouriteGenre());
        if (!booksForHim.isEmpty()) {
            LOGGER.info("---- BOOK FOUND ----");
            Book chosenBook = booksForHim.get(0);
            chosenBook.describeItself();
            onlyLibrary.startLeaseOfBook("10.11.2023", chosenBook, firstClient, 16);
            onlyLibrary.printListOfLeases();
        } else {
            LOGGER.info("We don't have books you're looking for.");
        }

        String titleOfBookToLease = "Historia pracy. Nowe dzieje ludzkosci";
        if(onlyLibrary.startLeaseOfBook("14.11.2023",titleOfBookToLease,secondClient,14)) {
            LOGGER.info("Has leased \""+titleOfBookToLease+"\" to client no. "+ secondClient.getClientNumber());
        } else {
            LOGGER.info("Failed to lease \""+titleOfBookToLease+"\" to client no. "+ secondClient.getClientNumber());
        }

        LOGGER.info("Program finished its tasks");
    }
}
