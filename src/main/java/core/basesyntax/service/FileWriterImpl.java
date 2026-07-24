package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String date, String fileName) {
        try {
            Files.writeString(Path.of(fileName), date);
        } catch (IOException e) {
            throw new RuntimeException("Can't write file:" + fileName,e);
        }
    }
}
