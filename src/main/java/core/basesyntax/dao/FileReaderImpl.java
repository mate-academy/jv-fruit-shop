package core.basesyntax.dao;

import core.basesyntax.exception.FruitShopException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (Exception e) {
            throw new FruitShopException("Can't read file: " + fileName, e);
        }
    }
}
