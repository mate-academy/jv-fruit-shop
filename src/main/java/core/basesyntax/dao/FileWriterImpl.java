package core.basesyntax.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String resultingReport, String fileName) {
        try {
            Files.write(Path.of(fileName), resultingReport.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to file " + fileName);
        }
    }
}
