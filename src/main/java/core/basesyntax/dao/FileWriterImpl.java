package core.basesyntax.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String resultingReport, String s) {
        try {
            Files.writeString(Path.of(s), resultingReport);
        } catch (IOException e) {
            throw new RuntimeException("Cant write file: " + s, e);
        }
    }
}
