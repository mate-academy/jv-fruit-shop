package core.basesyntax.service.impl;

import core.basesyntax.service.ReportReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReportReaderImpl implements ReportReader {
    public List<String> read(String path) {
        Path filePath = Paths.get(path);
        if (!Files.exists(filePath)) {
            throw new RuntimeException("Can't find file by path: " + path);
        }

        try {
            return Files.readAllLines(filePath, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file by path: " + path, e);
        }
    }
}
