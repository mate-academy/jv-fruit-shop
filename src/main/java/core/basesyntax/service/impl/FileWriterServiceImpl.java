package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void write(String pathToFile, String report) {
        File file = new File(pathToFile);
        try {
            Files.write(file.toPath(), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + pathToFile, e);
        }
    }
}
