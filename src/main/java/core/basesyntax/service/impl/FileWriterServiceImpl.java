package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void writeToFile(String pathToFile, String report) {
        Path path = Path.of(pathToFile);
        try {
            Files.writeString(path, report, StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write file " + path, e);
        }
    }
}
