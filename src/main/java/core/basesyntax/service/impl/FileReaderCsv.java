package core.basesyntax.service.impl;

import core.basesyntax.service.IFileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderCsv implements IFileReader {

    @Override
    public List<String> readFile(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Could not read file: " + filePath, e);
        }
    }
}
