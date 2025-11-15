package core.basesyntax.service.file.impl;

import core.basesyntax.service.file.ShopFileReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class ShopFileReaderImpl implements ShopFileReader {
    @Override
    public List<String> readCsv(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.lines().skip(1).toList();
        } catch (Exception e) {
            throw new RuntimeException("Can't find file by path: " + fileName, e);
        }
    }
}
