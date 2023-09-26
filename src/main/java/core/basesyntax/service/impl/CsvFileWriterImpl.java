package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CsvFileWriterImpl implements FileWriter {
    @Override
    public void writeToFile(String report, String fileName) {
        Path filePath = Paths.get(fileName);
        try {
            Files.write(filePath, report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while writing the report to the file: "
                    + fileName, e);
        }
    }
}
