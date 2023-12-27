package core.basesyntax.service.impl;

import core.basesyntax.service.TransactionReaderService;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileTransactionReaderService implements TransactionReaderService {
    private final String fileName;

    public CsvFileTransactionReaderService(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<String> read() {
        List<String> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            reader.readLine(); // Omitting string with headers
            String line;

            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File '" + fileName + "' not found.", e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file '" + fileName + "'.", e);
        }

        return list;
    }
}
