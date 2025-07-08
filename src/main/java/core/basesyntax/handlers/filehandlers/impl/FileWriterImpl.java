package core.basesyntax.handlers.filehandlers.impl;

import core.basesyntax.handlers.filehandlers.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String text, String name) {
        Path path = Paths.get(name);
        try {
            Files.write(path, text.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Errors create and write file: " + name, e);
        }
    }
}
