package core.basesyntax.service.impl;

import core.basesyntax.service.DataReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DataReaderCsv implements DataReader {

    @Override
    public List<String> read(String pathname) {
        Path path = Path.of(pathname);
        List<String> strings;

        try {
            strings = Files.readAllLines(path);
        } catch (IOException exception) {
            throw new RuntimeException(
                    "Can't find the file with this pathname: " + pathname, exception);
        }

        return strings;
    }
}
