package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
