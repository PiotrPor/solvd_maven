package com.solvd.solvdmaven;

import com.solvd.solvdmaven.interfaces.IStorageOfBooks;
import com.solvd.solvdmaven.interfaces.IForManagingBusiness;
import com.solvd.solvdmaven.exceptions.NonexistentIndexAccessedException;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Library implements IStorageOfBooks, IForManagingBusiness {
    public List<Employee> listOfEmployees;
    public List<Book> ourBooks;
    public List<Magazine> ourMagazines;
    public List<Lease> currentLeases;
    public MyLinkedListWithGeneric<Sale> listOfSales;
    private float income;
    private static final Logger LOGGER = LogManager.getLogger(Library.class);

    static {
        LOGGER.info(" ! We're ready to open our library ! ");
    }

    public Library() {
        listOfEmployees = new ArrayList<>();
        ourBooks = new ArrayList<>();
        ourMagazines = new ArrayList<>();
        currentLeases = new ArrayList<>();
        listOfSales = new MyLinkedListWithGeneric<Sale>();
        income = 0f;
    }

    //constructor with parameters had to be removed

    public void addEmployeeToList(Employee e) {
        this.listOfEmployees.add(e);
    }

    public void addBookToList(Book b) {
        this.ourBooks.add(b);
    }

    public void addMagazineToList(Magazine m) {
        this.ourMagazines.add(m);
    }

    public void addToIncome(float toBeAdded) {
        income += toBeAdded;
    }

    public float getIncome() {
        return income;
    }

    public List<Book> searchForBooksByTitle(String searchedTitle) {
        List<Book> foundBooks = new ArrayList<>();
        for (int i = 0; i < ourBooks.size(); i++) {
            if (ourBooks.get(i).title.equals(searchedTitle)) {
                foundBooks.add(ourBooks.get(i));
            }
        }
        return foundBooks;
    }

    public List<Book> searchForBooksByGenre(LiteratureGenre searchedGenre) {
        List<Book> foundBooks = new ArrayList<>();
        for (int i = 0; i < ourBooks.size(); i++) {
            if (ourBooks.get(i).getGenre() == searchedGenre) {
                foundBooks.add(ourBooks.get(i));
            }
        }
        return foundBooks;
    }

    public void startLeaseOfBook(String startingDate, Book b, Client thisClient, int lengthInDays) {
        currentLeases.add(new Lease(startingDate, b, thisClient.getClientNumber(), lengthInDays));
    }

    public void sellBook(String dateOfSale, Book b, Client thisClient) {
        listOfSales.add(new Sale(dateOfSale, b, thisClient.getClientNumber()));
    }

    public boolean startLeaseOfBook(String startingDate, String itsTitle, Client thisClient, int lengthInDays) {
        boolean wasLeasingSuccessful = false;
        int wantedIndex = getIndexOfBookByTitle(itsTitle);
        if(wantedIndex>=0 && wantedIndex<ourBooks.size()) {
            Book wantedBook = ourBooks.get(wantedIndex);
            startLeaseOfBook(startingDate,wantedBook,thisClient,lengthInDays);
            wasLeasingSuccessful = true;
        } else {
            LOGGER.warn("There is no such book to be leased: "+ itsTitle);
        }
        return wasLeasingSuccessful;
    }

    //for now there's no method to lease a magazine

    public void sellMagazine(String dateOfSale, Magazine m, Client thisClient) {
        listOfSales.add(new Sale(dateOfSale, m, thisClient.getClientNumber()));
    }

    public int getIndexOfBookByTitle(String searchedTitle) {
        int foundIndex = -1;
        for(int i=0; i<ourBooks.size(); i++) {
            if(ourBooks.get(i).getTitle().equals(searchedTitle)) {
                foundIndex = i;
                break;
            }
        }
        return foundIndex;
    }

    public void printListOfLeases() {
        if (!currentLeases.isEmpty()) {
            LOGGER.info("Leases we've done:");
            for (int i = 0; i < currentLeases.size(); i++) {
                LOGGER.info(Integer.toString(i + 1) + ") ");
                currentLeases.get(i).describeTransaction();
            }
        } else {
            LOGGER.info("The are no leases");
        }
    }

    public void printListOfSales() {
        if (!listOfSales.isEmpty()) {
            LOGGER.info("Sales we've done:");
            for (int i = 0; i < listOfSales.size(); i++) {
                LOGGER.info(Integer.toString(i + 1) + ") ");
                listOfSales.get(i).describeTransaction();
            }
        } else {
            LOGGER.info("Nothing has been sold");
        }
    }
}
