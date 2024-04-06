package core.basesyntax.impl;

import core.basesyntax.database.DataBase;
import core.basesyntax.service.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> readDataFromFile(String path) {
        List<String> fruitData = DataBase.listDb;
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                fruitData.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + path, e);
        }
        return fruitData;
    }
}
