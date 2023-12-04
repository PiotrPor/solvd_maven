package com.solvd.solvdmaven;

import com.solvd.solvdmaven.interfaces.IHasName;
import com.solvd.solvdmaven.enums.TypeOfPerson;

import java.util.function.BiConsumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Person implements IHasName {
    protected String name;
    protected String surname;
    protected TypeOfPerson typeOfThem;
    protected BiConsumer<String,String> setNameAndSurname;
    private static final Logger LOGGER = LogManager.getLogger(Person.class);

    public Person() {
        name = "John";
        surname = "Doe";
        typeOfThem = TypeOfPerson.OTHER;
        setNameAndSurname = (newN,newS) -> {name=newS; surname=newS;};
    }

    public Person(String fn, String sur) {
        name = fn;
        surname = sur;
        typeOfThem = TypeOfPerson.OTHER;
        setNameAndSurname = (newN,newS) -> {name=newS; surname=newS;};
    }

    public void setName(String newName) {
        if (newName.length() >= 2) {
            name = newName;
        } else {
            LOGGER.warn("First name can't be shorter than 2 characters!");
        }
    }

    public String getName() {
        return name;
    }

    public void setSurname(String newName) {
        if (newName.length() >= 2) {
            surname = newName;
        } else {
            LOGGER.warn("Surname can't be shorter than 2 characters!");
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setIdentity(String longString) {
        String newName, newSurname;
        int whereSpace = longString.indexOf(" ");
        newName = longString.substring(0, whereSpace);
        newSurname = longString.substring(whereSpace+1);
        setNameAndSurname.accept(newName,newSurname);
    }

    public String getIdentity() {
        return (name + " " + surname);
    }

    public TypeOfPerson getTheirType() {return typeOfThem;}

    //overriding methods from "Object" base class

    @Override
    public String toString() {
        return (name + " " + surname);
    }

    @Override
    public int hashCode() {
        int nameFirstLetterAscii = Character.getNumericValue(name.charAt(0));
        int surnameFirstLetterAscii = Character.getNumericValue(surname.charAt(0));
        return nameFirstLetterAscii + surnameFirstLetterAscii;
    }

    @Override
    public boolean equals(Object second) {
        //if compared object is this object
        if (second == this) {
            return true;
        }

        //if compared object isn't of "Person" class
        if (!(second instanceof Person)) {
            return false;
        }

        Person p2 = (Person) second;

        if (this.name.equals(p2.name) && this.surname.equals(p2.surname)) {
            return true;
        } else {
            return false;
        }
    }
}
