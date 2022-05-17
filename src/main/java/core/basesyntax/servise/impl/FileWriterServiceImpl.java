package core.basesyntax.servise.impl;

import core.basesyntax.servise.FileWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void write(String filePath, String report) {
        try {
            Files.write(Path.of(filePath), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file " + filePath, e);
        }
    }
}
