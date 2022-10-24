package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> read(String path) {
        List<String> infoLines;
        try {
            infoLines = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Can't read info from - " + path, e);
        }
        return infoLines;
    }
}
