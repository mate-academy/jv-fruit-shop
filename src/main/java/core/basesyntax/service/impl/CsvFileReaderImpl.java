package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderImpl implements FileReader {
    private final String sourceFilePath;

    public CsvFileReaderImpl(String sourceFilePath) {
        this.sourceFilePath = sourceFilePath;
    }

    @Override
    public List<String> getAll() {
        List<String> transactions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(sourceFilePath))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                transactions.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + sourceFilePath, e);
        }
        return transactions;
    }
}
