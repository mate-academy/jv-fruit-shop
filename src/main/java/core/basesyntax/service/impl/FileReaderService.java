package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderService implements ReaderService {
    private static final String REGEX_COMMA_DELIMITER = ",";

    @Override
    public List<String[]> readData(String filePath) {
        List<String[]> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                records.add(line.split(REGEX_COMMA_DELIMITER));
            }
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(String.format("File %s not found", filePath), ex);
        } catch (IOException ex) {
            throw new RuntimeException(String.format("Can`t read data from the file %s", filePath), ex);
        }
        return records;
    }
}
