package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImp implements WriterService {
    private static final String NULL_MESSAGE = "Report or FilePath can`t be null";
    private static final String EMPTY_MESSAGE = "Your report is empty";
    private static final String WRITE_EXCEPTION = "An error occurred while writing to the file: ";

    @Override
    public void writeFile(String report, String filePath) {
        if (report == null || filePath == null) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
        if (report.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_MESSAGE);
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException(WRITE_EXCEPTION, e);
        }
    }
}
