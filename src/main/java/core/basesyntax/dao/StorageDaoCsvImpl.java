package core.basesyntax.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class StorageDaoCsvImpl implements StorageDao {
    @Override
    public List<String> get(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file " + filePath + ", " + e);
        }
    }
}
