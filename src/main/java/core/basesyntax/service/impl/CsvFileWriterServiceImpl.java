package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileWriterService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {
    @Override
    public void writeToFile(String path, String data) {
        if (path == null || data == null) {
            throw new RuntimeException("Each param cannot be null!");
        }
        try {
            Files.write(Path.of(path), data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file");
        }
    }
}
