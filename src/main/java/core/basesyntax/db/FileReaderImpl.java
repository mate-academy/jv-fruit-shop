package core.basesyntax.db;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String fileName) {
        Path inputFile = Paths.get(fileName);
        try {
            return Files.readAllLines(inputFile);
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file: "
                    + fileName
                    + ", see description below.",e);
        }
    }
}
