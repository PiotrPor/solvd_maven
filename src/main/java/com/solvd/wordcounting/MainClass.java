package com.solvd.wordcounting;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.ArrayList;
import java.io.File;

public class MainClass {
    public static void main(String[] args) throws IOException {
        String titleOfTextFile = "about_Titanium.txt"; //will be needed later
        String filepath = "src/main/resources/" + titleOfTextFile;
        String fileAsString = FileUtils.readFileToString(FileUtils.getFile(filepath), StandardCharsets.UTF_8);

        fileAsString = StringUtils.lowerCase(fileAsString);

        for(int i=0; i<fileAsString.length(); i++) {
            char cc = fileAsString.charAt(i);
            if(!(Character.isLetter(cc) || cc == ' ')) {
                fileAsString = fileAsString.replace(cc,' ');
            }
        }

        List<String> separateWords = new ArrayList<>();

        for(String s2 : StringUtils.split(fileAsString," ")) {
            s2 = s2.trim(); //remove whitespaces from beginning or end
            if(!separateWords.contains(s2)) {
                separateWords.add(s2);
            }
        }

        String descriptionOfResult = "In \""+ titleOfTextFile +"\" there were ";
        descriptionOfResult += separateWords.size() +" unique words.";
        File fileWithResult = new File("results.txt");
        // write/overwrite to file, create file if it doesn't exist
        FileUtils.writeStringToFile(fileWithResult, descriptionOfResult, StandardCharsets.UTF_8, false);
    }
}
