package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvWriterServiceImpl implements WriterService {
    @Override
    public void write(String path, String data) {
        try {
            Files.write(Path.of(path), data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file");
        }
    }
}
