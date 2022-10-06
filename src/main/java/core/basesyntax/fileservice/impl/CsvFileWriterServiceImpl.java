package core.basesyntax.fileservice.impl;

import core.basesyntax.fileservice.CsvFileWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {
    @Override
    public void writeToFile(String info, String path) {
        try {
            Files.write(Path.of(path), info.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write info to file");
        }
    }
}
