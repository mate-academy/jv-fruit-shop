package core.basesyntax.filework.impl;

import core.basesyntax.filework.ShopFileReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ShopFileReaderImpl implements ShopFileReader {
    @Override
    public List<String> readFromFile(String filename) {
        File file = new File(filename);
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file: " + file, e);
        }
    }
}
