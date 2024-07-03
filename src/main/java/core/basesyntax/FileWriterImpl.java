package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {

    @Override
    public void write(String report, String file) {
        try {
            Files.write(Path.of(file), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("There was an error writing report.", e);
        }
    }
}
