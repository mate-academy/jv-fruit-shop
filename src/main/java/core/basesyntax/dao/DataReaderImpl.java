package core.basesyntax.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DataReaderImpl implements DataReader {
    private static final int FIRST_LINE_INDEX = 0;

    @Override
    public List<String> readFromFile(String filePath) {
        List<String> data;
        try {
            data = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + filePath, e);
        }
        data.remove(FIRST_LINE_INDEX);
        return data;
    }
}

