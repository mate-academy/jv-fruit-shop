package core.service.impl;

import core.service.CsvWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvWriterServiceImpl implements CsvWriterService {
    @Override
    public void write(String fileName, String report) {
        try {
            Files.write(Path.of(fileName),report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + fileName, e);
        }
    }
}
