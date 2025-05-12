package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> readFromFile(String filePath) {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            try {
                throw new FileNotFoundException("Can't find file by path: " + filePath);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file: " + e.getMessage());
        }

    }
}
