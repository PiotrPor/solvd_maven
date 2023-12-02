package com.solvd.solvdmaven;

import com.solvd.solvdmaven.enums.LiteratureGenre;
import com.solvd.solvdmaven.enums.TypeOfPerson;

public final class Client extends Person {
    private int clientNumber;
    private LiteratureGenre favouriteGenre;

    public Client() {
        super();
        typeOfThem = TypeOfPerson.CLIENT;
        clientNumber = 0;
        favouriteGenre = LiteratureGenre.OTHER;
    }

    public Client(String theirName, String theirSurname, int theirNumber, LiteratureGenre theirFavourite) {
        super(theirName, theirSurname);
        typeOfThem = TypeOfPerson.CLIENT;
        clientNumber = theirNumber;
        favouriteGenre = theirFavourite;
    }

    public void setClientNumber(int newNumber) {
        clientNumber = newNumber;
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
