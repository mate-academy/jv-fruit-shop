package core.basesyntax.impl;

import core.basesyntax.service.FileWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void writeToFile(String toFileName, String text) {
        try {
            Files.write(Path.of(toFileName), text.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write to a file " + toFileName, e);
        }
    }
}
