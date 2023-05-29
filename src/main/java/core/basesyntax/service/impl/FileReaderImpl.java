package core.basesyntax.service.impl;

import core.basesyntax.service.CSVFileReader;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements CSVFileReader {
    private final String fileName;

    public FileReaderImpl(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public List<String> readFile() {
        List<String> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                count++;
                if (count > 1) {
                    data.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
