package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFile(String filePath) {
        validateFilePath(filePath);
        List<String> list;
        try {
            list = Files.readAllLines(Path.of(filePath));
        } catch (IOException ex) {
            throw new RuntimeException("File path is wrong, can't read a file");
        }
        return list;
    }

    private void validateFilePath(String filePath) {
        if (filePath == null) {
            throw new RuntimeException("File path is null");
        }
        if (!filePath.endsWith("csv")) {
            throw new RuntimeException("File path is not a CSV file: " + filePath);
        }
    }
}
