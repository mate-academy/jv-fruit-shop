package core.basesyntax.fileservice.impl;

import core.basesyntax.fileservice.FileWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void writeToFile(String info, String path) {
        try {
            Files.write(Path.of(path), info.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write information to file with path: " + path, e);
        }
    }
}
