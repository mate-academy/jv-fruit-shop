package core.basesyntax.service.cvs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeToFile(String toFile, String data) {
        try {
            Files.write(Path.of(toFile), data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to a file: " + toFile, e);
        }
    }
}
