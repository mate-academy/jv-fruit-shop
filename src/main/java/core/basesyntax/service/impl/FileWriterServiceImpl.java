package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void writeToFile(String report, File file) {
        try {
            Files.write(file.toPath(), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + file, e);
        }
    }
}
