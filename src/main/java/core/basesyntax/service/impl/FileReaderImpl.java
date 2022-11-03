package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> readFile(String scvFilePath) {
        try {
            if (scvFilePath == null) {
                throw new RuntimeException("File path can`t be null");
            }
            return Files.readAllLines(Path.of(scvFilePath));
        } catch (IOException e) {
            throw new RuntimeException("Can`t get data from file");
        }
    }
}
