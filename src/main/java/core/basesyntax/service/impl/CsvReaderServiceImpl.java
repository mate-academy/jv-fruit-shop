package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class CsvReaderServiceImpl implements ReaderService {
    private File file;

    public CsvReaderServiceImpl(String filePath) {
        file = new File(filePath);
    }

    @Override
    public List<String> getLines() {
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file: " + file);
        }
    }
}
