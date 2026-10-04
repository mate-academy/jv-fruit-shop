package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> read(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            throw new IllegalArgumentException("File name can not be null or empty");
        }
        try {
            List<String> lines = Files.readAllLines(Path.of(fileName));
            return lines.stream()
                    .filter(s -> !s.trim().isEmpty())
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException("Can not read the file: " + fileName, e);
        }
    }
}
