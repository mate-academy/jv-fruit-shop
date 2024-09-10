package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void write(String resultingReport, String filePath) {
        File file = new File(filePath);
        try {
            Files.write(file.toPath(), resultingReport.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file, " + e);
        }
    }
}
