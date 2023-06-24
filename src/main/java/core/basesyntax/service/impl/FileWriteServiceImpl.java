package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriteService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriteServiceImpl implements FileWriteService {
    @Override
    public void writeToFile(String text, String filePath) {
        try {
            Files.writeString(Path.of(filePath), text);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + filePath, e);
        }
    }
}
