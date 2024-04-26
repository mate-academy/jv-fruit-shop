package service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderService {
    public List<String> readFromFile(String fileName) {
        List<String> fruitTransactions = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            String readedLineFromFile;
            fileReader.readLine();
            while ((readedLineFromFile = fileReader.readLine()) != null) {
                fruitTransactions.add(readedLineFromFile.trim());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + fileName, e);
        }
        return fruitTransactions;
    }
}
