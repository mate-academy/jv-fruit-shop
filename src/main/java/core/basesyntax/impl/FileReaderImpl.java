package core.basesyntax.impl;

import core.basesyntax.database.DataBase;
import core.basesyntax.service.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class FileReaderImpl implements FileReader {
    private static final int INDEX_OF_OPERATION_TYPE = 0;
    private static final int INDEX_OF_FRUIT_TYPE = 1;
    private static final int INDEX_OF_FRUIT_QUANTITY = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<String> readDataFromFile(String path) {
        List<String> fruitData = DataBase.listDb;
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(path))) {
            String line;// Skip header
            while ((line = br.readLine()) != null) {
                fruitData.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + path);
        }
        return fruitData;
    }
}
