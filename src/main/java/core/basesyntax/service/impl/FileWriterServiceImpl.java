package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void writeToFile(String text, String filePath) {
        try {
            Files.writeString(Path.of(filePath), text);
        } catch (IOException e) {
            throw new RuntimeException("Can't write text to file by path: " + filePath, e);
        }
    }
}
