package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String data, String filePath) {
        try {
            Files.write(Paths.get(filePath), data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file: " + filePath, e);
        }
    }
}