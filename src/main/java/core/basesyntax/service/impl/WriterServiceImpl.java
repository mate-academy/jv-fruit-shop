package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToCsv(String generatedReport, String filePath) {
        validateReport(generatedReport);
        validateFilePath(filePath);
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(generatedReport);
        } catch (IOException e) {
            throw new RuntimeException("File path is wrong, can't write a file");
        }
    }

    private void validateReport(String report) {
        if (report == null) {
            throw new RuntimeException("Report is null");
        }
    }

    private void validateFilePath(String filePath) {
        if (filePath == null) {
            throw new RuntimeException("File path is null");
        }
        if (!filePath.endsWith("csv")) {
            throw new RuntimeException("File path is not a CSV file: " + filePath);
        }
    }
}
