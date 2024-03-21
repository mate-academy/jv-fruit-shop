package core.basesyntax.service.serviceimpl;

import core.basesyntax.exception.NoFileToReadException;
import core.basesyntax.service.interfaces.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> readFile(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new NoFileToReadException("Cannot read from file" + e.getMessage());
        }
    }
}
