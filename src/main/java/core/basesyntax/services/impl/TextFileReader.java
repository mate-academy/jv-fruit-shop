package core.basesyntax.services.impl;

import core.basesyntax.exceptions.FileOperationException;
import core.basesyntax.services.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TextFileReader implements FileReader {
    @Override
    public List<String> readFile(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new FileOperationException("Can't read from file ", e);
        }
    }
}
