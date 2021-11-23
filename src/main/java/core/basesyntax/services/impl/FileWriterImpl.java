package core.basesyntax.services.impl;

import core.basesyntax.services.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String filePath, String data) {
        try {
            Files.write(Path.of(filePath), data.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException("Unable to write to file", e);
        }
    }
}
