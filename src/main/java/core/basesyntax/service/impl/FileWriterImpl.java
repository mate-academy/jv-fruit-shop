package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String content, String fileName) {
        Objects.requireNonNull(content);
        Objects.requireNonNull(fileName);
        try {
            Files.write(Paths.get(fileName), content.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException("Unable to write file: " + fileName, e);
        }
    }
}
