package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String filePath, String report) {
        try {
            Files.write(new File(filePath).toPath(), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write to a file", e);
        }
    }
}
