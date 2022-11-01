package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeDataToFile(String report, String pathToFile) {
        try {
            Files.write(Path.of(pathToFile), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write report " + report + " to file " + pathToFile);
        }
    }
}
