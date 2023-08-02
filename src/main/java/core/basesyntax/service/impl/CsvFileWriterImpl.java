package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CsvFileWriterImpl implements FileWriter {
    @Override
    public void writeToFile(List<String> report, String fileName) {
        Path filePath = Paths.get(fileName);
        try {
            Files.write(filePath, report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write report in file ", e);
        }
    }
}
