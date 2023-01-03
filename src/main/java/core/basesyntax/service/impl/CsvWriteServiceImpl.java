package core.basesyntax.service.impl;

import core.basesyntax.service.CsvWriteService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvWriteServiceImpl implements CsvWriteService {
    @Override
    public void writeReport(String path, String report) {
        try {
            Files.writeString(Path.of(path), report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to the file " + path, e);
        }
    }
}
