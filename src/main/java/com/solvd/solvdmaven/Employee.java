package com.solvd.solvdmaven;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Employee extends Person {
    private int employeeNumber;
    private float salary;
    private static final Logger LOGGER = LogManager.getLogger(Employee.class);

    public Employee() {
        super();
        employeeNumber = 0;
        salary = 3000f;
    }

    public Employee(String nm, String sn, int epnb, float slr) {
        super(nm, sn);
        employeeNumber = epnb;
        salary = slr;
    }

    public void setEmployeeNumber(int newNumber) {
        employeeNumber = newNumber;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setSalary(float newSalary) {
        if (newSalary > 0f) {
            salary = newSalary;
        } else {
            LOGGER.warn("Salary can't be zero!");
        }
    }

    public float getSalary() {
        return salary;
    }

    //override Object methods

    @Override
    public String toString() {
        return (name + " " + surname + " - employee no. " + employeeNumber);
    }

    @Override
    public int hashCode() {
        int nameFirstLetterAscii = Character.getNumericValue(name.charAt(0));
        int surnameFirstLetterAscii = Character.getNumericValue(surname.charAt(0));
        return nameFirstLetterAscii + surnameFirstLetterAscii + employeeNumber;
    }

    @Override
    public boolean equals(Object second) {
        //if compared object is this object
        if (second == this) {
            return true;
        }

        //if compared object isn't of "Employee" class
        if (!(second instanceof Employee)) {
            return false;
        }

        Employee p2 = (Employee) second;

        if (this.name.equals(p2.name) &&
                this.surname.equals(p2.surname) &&
                this.employeeNumber == p2.employeeNumber) {
            return true;
        } else {
            return false;
        }
    }
}
