package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterCsvImpl implements FileWriter {
    @Override
    public void writeToFile(String data, String path) {
        try {
            Files.writeString(Path.of(path), data);
        } catch (IOException e) {
            throw new RuntimeException("Cannot write to file :" + path, e);
        }
    }
}
