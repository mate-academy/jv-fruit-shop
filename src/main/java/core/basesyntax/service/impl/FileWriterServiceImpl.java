package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void writeToFile(String toFileName, StringBuilder report) {
        try {
            Files.write(Path.of(toFileName), report.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + toFileName, e);
        }
    }
}
