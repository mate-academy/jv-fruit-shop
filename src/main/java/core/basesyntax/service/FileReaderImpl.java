package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(Path filePath) {
        List<String> records = new ArrayList<>();
        if (filePath.toFile().exists()) {
            try {
                records = Files.readAllLines(filePath);
            } catch (IOException e) {
                throw new RuntimeException("Can't read file: " + filePath, e);
            }
        } else {
            throw new RuntimeException("File: " + "'" + filePath + "'" + " doesn't exist.");
        }
        return records;
    }
}
