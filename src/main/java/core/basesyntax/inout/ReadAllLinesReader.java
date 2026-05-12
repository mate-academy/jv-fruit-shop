package core.basesyntax.inout;

import core.basesyntax.exception.DataProcessingException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class ReadAllLinesReader implements LineReader {

    @Override
    public Stream<String> readLines(String path) {
        try {
            return Files.readAllLines(Path.of(path)).stream();
        } catch (IOException e) {
            throw new DataProcessingException("Can't read lines from file: " + path, e);
        }
    }
}
