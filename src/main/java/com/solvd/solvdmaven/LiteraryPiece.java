package com.solvd.solvdmaven;

import com.solvd.solvdmaven.enums.LiteratureGenre;
import com.solvd.solvdmaven.enums.LiteraturePieceType;
import com.solvd.solvdmaven.interfaces.IPurchasable;
import com.solvd.solvdmaven.exceptions.RemovingTitleException;
import com.solvd.solvdmaven.exceptions.NegativeCostException;

import java.util.function.Supplier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

abstract public class LiteraryPiece implements IPurchasable {
    protected String title;
    public String publisher;
    public String publishDate;
    protected LiteratureGenre genre;
    protected float price;
    protected LiteraturePieceType theirType;
    public Supplier<Float> returnValueOfPrice;
    private static final Logger LOGGER = LogManager.getLogger(LiteraryPiece.class);

    public LiteraryPiece() {
        title = " ";
        publisher = " ";
        publishDate = "31-12-1900";
        genre = LiteratureGenre.OTHER;
        price = 0f;
        theirType = LiteraturePieceType.OTHER;
        returnValueOfPrice = () -> {return this.price;};
    }

    public LiteraryPiece(String newTitle, String newPublish, String whenPublished, LiteratureGenre whatGenre, float newPrice) {
        title = newTitle;
        publisher = newPublish;
        publishDate = whenPublished;
        genre = whatGenre;
        price = newPrice;
        theirType = LiteraturePieceType.OTHER;
        returnValueOfPrice = () -> {return this.price;};
    }

    public void setTitle(String newTitle) throws RemovingTitleException {
        try (ClassCheckingForStringContent cc = new ClassCheckingForStringContent(newTitle)) {
            cc.checkIfBlank();
            title = newTitle;
        } catch(RuntimeException e) {
            throw new RemovingTitleException("Exception when changing title: "+ e.getMessage());
        }
    }

    public String getTitle() {
        return title;
    }

    public final void setGenre(LiteratureGenre newGenre) {
        genre = newGenre;
    }

    public final LiteratureGenre getGenre() {
        return genre;
    }

    public void setPrice(float newPrice) throws NegativeCostException {
        if (newPrice >= 0f) {
            price = newPrice;
        } else {
            throw new NegativeCostException("Price can't be negative");
        }
    }

    public float getPrice() {
        return returnValueOfPrice.get();
    }

    public LiteraturePieceType getItsType() {return theirType;}

    abstract public void describeItself();
}
