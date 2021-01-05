package core.basesyntax.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileWriterImpl implements FileWriter {

    @Override
    public void writeToFile(List<String> transactions, String fileName) {
        try {
            Files.write(Path.of(fileName), transactions);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + fileName);
        }
    }
}
