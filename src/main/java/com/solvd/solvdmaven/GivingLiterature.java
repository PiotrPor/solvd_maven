package com.solvd.solvdmaven;

import com.solvd.solvdmaven.enums.TypeOfTransaction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GivingLiterature {
    protected String dateWhen;
    protected LiteraryPiece pieceOfLiterature;
    protected int clientNumber;
    protected TypeOfTransaction itsType;
    private static final Logger LOGGER = LogManager.getLogger(GivingLiterature.class);

    public GivingLiterature() {
        dateWhen = "06.11.2023";
        pieceOfLiterature = new Book();
        clientNumber = 0;
        itsType = TypeOfTransaction.OTHER;
    }

    public GivingLiterature(String when, LiteraryPiece lp, int cn) {
        dateWhen = when;
        pieceOfLiterature = lp;
        clientNumber = cn;
        itsType = TypeOfTransaction.OTHER;
    }

    public String getDateWhen() {
        return dateWhen;
    }

    public void setDateWhen(String newDate) {
        boolean isDate = false;
        for (int i = 0; i < newDate.length(); i++) {
            if (!Character.isDigit(newDate.charAt(i))) {
                isDate = true;
                break;
            }
        }
        if (isDate) {
            dateWhen = newDate;
        } else {
            LOGGER.warn("Date must have separators.");
        }
    }

    public void setPieceOfLiterature(LiteraryPiece newLP) {
        pieceOfLiterature = newLP;
    }

    public LiteraryPiece getPieceOfLiterature() {
        return pieceOfLiterature;
    }

    public void setClientNumber(int newClientNumber) {
        clientNumber = newClientNumber;
    }

    public int getClientNumber() {
        return clientNumber;
    }

    public TypeOfTransaction getItsType() {return itsType;}
}
