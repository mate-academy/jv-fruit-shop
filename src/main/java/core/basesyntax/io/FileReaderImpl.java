package core.basesyntax.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> readFromFile(String pathToFile) {
        List<String> transactions;
        try {
            transactions = Files.readAllLines(Path.of(pathToFile));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file: " + pathToFile, e);
        }
        return transactions;
    }
}
