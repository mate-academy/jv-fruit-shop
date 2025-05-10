package core.basesyntax.service.impl;

import core.basesyntax.service.DataReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DataReaderCsv implements DataReader {
    @Override
    public List<String> read(String path) {
        Path filePath = Path.of(path);
        List<String> strings;

        try {
            strings = Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new RuntimeException(
                    "Can't find the file by path: " + path, e);
        }

        return strings;
    }
}
