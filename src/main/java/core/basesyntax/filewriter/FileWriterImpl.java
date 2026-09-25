package core.basesyntax.filewriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeToFile(String data, String filename) {
        Path filePath = Path.of(filename);
        try {
            Files.write(filePath, data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + filename, e);
        }
    }
}
