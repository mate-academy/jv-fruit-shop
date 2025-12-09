package core.basesyntax.service.io;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterImpl implements FileWriter {
    @Override
    public void output(String report, String path) {
        try {
            Files.writeString(Paths.get(path), report);
        } catch (IOException e) {
            throw new RuntimeException("Error writing report to file: " + path, e);
        }
    }
}
