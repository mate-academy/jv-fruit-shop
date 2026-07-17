package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String content, String filePath) {
        try {
            Files.writeString(Path.of(filePath), content);
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        }

    }
}
