package core.basesyntax.service.impl.reader;

import core.basesyntax.service.DataReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements DataReader {
    @Override
    public List<String> read(String dataPath) {
        if (dataPath == null) {
            throw new IllegalArgumentException("Data path can't be null");
        }

        try {
            return Files.readAllLines(Path.of(dataPath));
        } catch (Exception e) {
            throw new RuntimeException("Can't read file: " + dataPath, e);
        }
    }
}
