package core.basesyntax.service.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileReader implements FileReader {
    private static final String EXCEPTION_MESSAGE = " Can't read file! ";

    @Override
    public List<String> readFile(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(EXCEPTION_MESSAGE, e);
        }
    }
}
