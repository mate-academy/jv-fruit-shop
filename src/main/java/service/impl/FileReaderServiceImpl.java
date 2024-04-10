package service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import service.FileReaderService;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readFromFile(File activitiesFile) {
        List<String> fruitTransactions = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(activitiesFile))) {
            String readedLineFromFile;
            fileReader.readLine();
            while ((readedLineFromFile = fileReader.readLine()) != null) {
                fruitTransactions.add(readedLineFromFile.trim());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + activitiesFile, e);
        }
        return fruitTransactions;
    }
}
