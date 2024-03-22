package core.basesyntax.service.impl;

import core.basesyntax.service.DataReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FruitDataReaderService implements DataReaderService {

    @Override
    public List<String> read(String filePath) {
        try {
            List<String> file = Files.readAllLines(Path.of(filePath));
            return file;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
