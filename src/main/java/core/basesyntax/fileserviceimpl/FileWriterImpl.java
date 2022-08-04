package core.basesyntax.fileserviceimpl;

import core.basesyntax.fileservice.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeToFile(String filePath, String data) {
        try {
            Files.write(Path.of(filePath), data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Cannot write to this file: " + filePath);
        }
    }
}
