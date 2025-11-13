package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterImpl implements FileWriter {

    @Override
    public void write(String content, String fileName) {
        try {
            Files.writeString(Paths.get(fileName), content);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to file: " + fileName, e);
        }
    }
}
