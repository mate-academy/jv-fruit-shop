package core.basesyntax.service.impl;

import core.basesyntax.exception.FileWritingFailureException;
import core.basesyntax.service.DataWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CsvReportWriter implements DataWriter {
    private static final String WRITING_FAILURE_MESSAGE = "Failed to write to the file";

    @Override
    public void write(String data, String fileName) {
        byte[] reportToBytes = data.getBytes();
        try {
            Files.write(Paths.get(fileName), reportToBytes);
        } catch (IOException e) {
            throw new FileWritingFailureException(WRITING_FAILURE_MESSAGE + fileName, e);
        }
    }
}
