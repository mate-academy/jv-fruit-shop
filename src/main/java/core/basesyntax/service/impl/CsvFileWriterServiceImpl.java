package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterServiceImpl implements FileWriter {
    @Override
    public void write(String report, String toFile) {
        try {
            Files.writeString(Paths.get(toFile), report);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
