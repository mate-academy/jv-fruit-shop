package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterCsvImpl implements FileWriter {

    @Override
    public void writeToFile(String content, String path) {
        try {
            Files.writeString(Path.of(path), content);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + path, e);
        }
    }
}
