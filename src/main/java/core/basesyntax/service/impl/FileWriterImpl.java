package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String content, String filePath) {
        try {
            Files.write(Paths.get(filePath), content.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file by path - " + filePath, e);
        }
    }
}
