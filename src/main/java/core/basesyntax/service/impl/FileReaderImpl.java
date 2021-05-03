package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderInterface;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReaderInterface {
    private static final int INDEX_OF_COLUMNS_NAME = 0;
    private List<String> records = new ArrayList<>();

    @Override
    public List<String> readFromFile(String filePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                records.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + filePath, e);
        }
        records.remove(INDEX_OF_COLUMNS_NAME);
        return records;
    }
}
