package core.basesyntax.service.impl;

import core.basesyntax.service.FileCsvWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileCsvWriterImpl implements FileCsvWriter {
    @Override
    public void writeToFile(String content, String filePath) {
        try {
            Files.writeString(Path.of(filePath), content);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + filePath, e);
        }
    }
}
