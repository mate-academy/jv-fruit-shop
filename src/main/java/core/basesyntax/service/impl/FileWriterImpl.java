package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeToFile(String fileName, String report) {
        try {
            Files.write(Paths.get(fileName), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: " + fileName, e);
        }
    }
}
