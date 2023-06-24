package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriteService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriteServiceImpl implements FileWriteService {
    @Override
    public void writeToFile(String path, String report) {
        try {
            Files.writeString(Path.of(path), report);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to file " + e);
        }
    }
}
