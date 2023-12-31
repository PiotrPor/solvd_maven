package com.solvd.solvdmaven;

import com.solvd.solvdmaven.enums.LiteratureGenre;
import com.solvd.solvdmaven.enums.TypeOfPerson;
import com.solvd.solvdmaven.interfaces.IFuncForLambdas;

import java.util.concurrent.atomic.AtomicInteger;

public final class Client extends Person {
    private int clientNumber;
    private LiteratureGenre favouriteGenre;
    private AtomicInteger ourAtomInt;
    IFuncForLambdas<Integer> iffl;

    public Client() {
        super();
        typeOfThem = TypeOfPerson.CLIENT;
        clientNumber = 0;
        favouriteGenre = LiteratureGenre.OTHER;
        ourAtomInt = new AtomicInteger();
        iffl = (someInt) -> {ourAtomInt.set(someInt);};
    }

    public Client(String theirName, String theirSurname, int theirNumber, LiteratureGenre theirFavourite) {
        super(theirName, theirSurname);
        typeOfThem = TypeOfPerson.CLIENT;
        clientNumber = theirNumber;
        favouriteGenre = theirFavourite;
        ourAtomInt = new AtomicInteger();
        iffl = (someInt) -> {ourAtomInt.set(someInt);};
    }

    public void setClientNumber(int newNumber) {
        iffl.setValue(newNumber);
        this.clientNumber = ourAtomInt.get();
    }

    public int getClientNumber() {
        return clientNumber;
    }

    public void setFavouriteGenre(LiteratureGenre newFavourite) {
        favouriteGenre = newFavourite;
    }

    public LiteratureGenre getFavouriteGenre() {
        return favouriteGenre;
    }

    // Override Object methods

    @Override
    public String toString() {
        return (name + " " + surname + " - client no. " + clientNumber);
    }

    @Override
    public int hashCode() {
        int nameFirstLetterAscii = Character.getNumericValue(name.charAt(0));
        int surnameFirstLetterAscii = Character.getNumericValue(surname.charAt(0));
        return nameFirstLetterAscii + surnameFirstLetterAscii + clientNumber;
    }

    @Override
    public boolean equals(Object second) {
        //if compared object is this object
        if (second == this) {
            return true;
        }

        //if compared object isn't of "Client" class
        if (!(second instanceof Client)) {
            return false;
        }

        Client p2 = (Client) second;

        if (this.name.equals(p2.name) &&
                this.surname.equals(p2.surname) &&
                this.clientNumber == p2.clientNumber) {
            return true;
        } else {
            return false;
        }
    }
}
