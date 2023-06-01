package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeToFile(String pathToFile, String content) {
        try {
            Files.write(Path.of(pathToFile), content.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file with path: " + pathToFile, e);
        }
    }
}
