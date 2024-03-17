package core.basesyntax.service.impl;

import core.basesyntax.service.DataWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CsvReportWriter implements DataWriter {
    private static final String WRITING_FAILURE_MESSAGE= "Failed to write to the file";
    @Override
    public void writeReportToTheFile(String report, String fileName) {
        byte[] reportToBytes = report.getBytes();
        try {
            Files.write(Paths.get(fileName), reportToBytes);
        } catch (IOException e) {
            throw new RuntimeException(WRITING_FAILURE_MESSAGE + fileName, e);
        }
    }
}
