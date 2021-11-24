package core.basesyntax.service.impl;

import core.basesyntax.service.FruitShopFileReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FruitShopFileReaderImpl implements FruitShopFileReader {
    @Override
    public List<String> read(String fileName) {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String readLine = reader.readLine();
            do {
                list.add(readLine);
                readLine = reader.readLine();
            } while (readLine != null);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }
        return list;
    }
}
