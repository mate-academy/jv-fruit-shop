package core.basesyntax.service.impl;

import core.basesyntax.service.ShopFileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ShopFileReaderCsvImpl implements ShopFileReader {

    @Override
    public List<String> readFromFile(String fileName) {
        List<String> dataBase;
        try {
            dataBase = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("File not found - " + fileName, e);
        }
        return dataBase;
    }
}
