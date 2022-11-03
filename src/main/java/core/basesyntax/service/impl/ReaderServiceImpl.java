package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private static final String CANNOT_FIND_FILE_BY_PATH = "Can't find file by path: ";
    private static final String ERROR_WHILE_READING = "I/O error occurs while reading from: ";

    @Override
    public List<String> readFromFile(String filePath) {
        List<String> records = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                records.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(CANNOT_FIND_FILE_BY_PATH + filePath, e);
        } catch (IOException e) {
            throw new RuntimeException(ERROR_WHILE_READING + filePath, e);
        }
        return records;
    }
}
