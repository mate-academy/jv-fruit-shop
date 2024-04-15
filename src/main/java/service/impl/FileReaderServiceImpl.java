package service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import service.FileReaderService;

public class FileReaderServiceImpl implements FileReaderService {
    private final String pathToInputFile = "src/main/resources/file.csv";

    @Override
    public List<String> readFromFile() {
        List<String> fruitTransactions = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(pathToInputFile))) {
            String readedLineFromFile;
            fileReader.readLine();
            while ((readedLineFromFile = fileReader.readLine()) != null) {
                fruitTransactions.add(readedLineFromFile.trim());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + pathToInputFile, e);
        }
        return fruitTransactions;
    }
}
