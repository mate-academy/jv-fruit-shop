package core.basesyntax.inout;

import core.basesyntax.exception.DataProcessingException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class StreamLinesReader implements LineReader {

    @Override
    public Stream<String> readLines(String path) {
        try {
            return Files.lines(Path.of(path));
        } catch (IOException e) {
            throw new DataProcessingException("Can't read lines from file: " + path, e);
        }
    }
}
