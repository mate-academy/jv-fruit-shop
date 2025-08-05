package core.basesyntax.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String filePath) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            return reader.lines().skip(1).toList();
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file: " + filePath, e);
        }

    }
}
