package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderImpl implements CsvFileReader {
    @Override
    public List<String> readData(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            List<String> transactionDtos = new ArrayList<>();
            String value = reader.readLine();
            while (value != null) {
                transactionDtos.add(value);
                value = reader.readLine();
            }
            return transactionDtos;
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from the file " + fileName, e);
        }
    }
}
