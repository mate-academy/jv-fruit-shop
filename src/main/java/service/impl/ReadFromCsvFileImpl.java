package service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import service.ReadFromFile;

/*
This class reads all data from the file and returns it in one String value.
- receive String filePath
- return String textBox
 */
public class ReadFromCsvFileImpl implements ReadFromFile {
    @Override
    public String readFromCsvFile(String filePath) {
        File file = new File(filePath);
        StringBuilder textBox = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            if (file.length() == 0) {
                System.out.println("File: " + filePath + "is empty.");
            }
            int symbol = 0;
            while ((symbol = reader.read()) != -1) {
                textBox.append((char) symbol);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + filePath, e);
        }
        return textBox.toString();
    }
}
