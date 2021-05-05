package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DataReader implements Reader {

    public DataReader() { }

    @Override
    public List<String> readData(String sourceName) throws IOException {
        try {
            return Files.readAllLines(Path.of(sourceName));
        } catch (IOException e) {
            throw new IOException("Can't read file", e);
        }
    }
}
