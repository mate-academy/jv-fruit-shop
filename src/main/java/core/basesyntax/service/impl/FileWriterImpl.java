package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeReportToFile(String inputData, String filePath) {
        try {
            Files.write(Paths.get(filePath), inputData.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Error while writing to file: " + filePath, e);
        }
    }
}
