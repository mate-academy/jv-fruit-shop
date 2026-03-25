package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String result, String path) {
        try {
            Files.writeString(Path.of(path), result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
