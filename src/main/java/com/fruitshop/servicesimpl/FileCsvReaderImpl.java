package com.fruitshop.servicesimpl;

import com.fruitshop.services.FileCsvReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileCsvReaderImpl implements FileCsvReader {
    private final List<String> listOfCsvFile = new ArrayList<>();

    public List<String> readFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String input = reader.readLine();
            while (input != null) {
                listOfCsvFile.add(input);
                input = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can not read from file " + filePath);
        }
        return listOfCsvFile;
    }

}
