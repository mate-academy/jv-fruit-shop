package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void writeToFile(String fileName, String report) {
        Path path = Paths.get(fileName);
        try {
            Files.writeString(path,report);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + fileName,e);
        }
    }
}
