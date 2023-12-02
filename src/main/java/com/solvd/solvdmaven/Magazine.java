package com.solvd.solvdmaven;

import com.solvd.solvdmaven.enums.LiteratureGenre;

import com.solvd.solvdmaven.enums.LiteraturePieceType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Magazine extends LiteraryPiece {
    private int issueNumber;
    private static final Logger LOGGER = LogManager.getLogger(Magazine.class);

    public Magazine() {
        super();
        theirType = LiteraturePieceType.MAGAZINE;
        issueNumber = 1;
    }

    public Magazine(String newTitle, String newPublish, String whenPublished, LiteratureGenre whatGenre, float newPrice, int whatNumber) {
        super(newTitle, newPublish, whenPublished, whatGenre, newPrice);
        theirType = LiteraturePieceType.MAGAZINE;
        issueNumber = whatNumber;
    }

    public void setIssueNumber(int newNumber) {
        if (newNumber >= 0) {
            issueNumber = newNumber;
        } else {
            LOGGER.warn("Issue number can't be lower than 0.");
        }
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void describeItself() {
        LOGGER.info(this.toString());
    }

    @Override
    public String toString() {
        String writtenText = "Magazine titled \"" + title + "\"\n";
        writtenText += "Genre: " + genre.toString() + "\n";
        writtenText += "Issue number: " + Integer.toString(issueNumber) + " dated on " + publishDate + "\n";
        writtenText += "Published by " + publisher + "\n";
        writtenText += "Price: " + Float.toString(price) + " PLN\n";
        return writtenText;
    }
}
