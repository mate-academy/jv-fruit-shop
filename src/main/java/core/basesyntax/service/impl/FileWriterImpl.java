package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeToFile(String content, String filePath) {
        Path pathToFile = Path.of(filePath);
        try {
            Files.writeString(pathToFile, content);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + pathToFile);
        }
    }
}
