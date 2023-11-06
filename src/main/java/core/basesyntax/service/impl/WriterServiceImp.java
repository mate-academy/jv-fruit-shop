package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImp implements WriterService {
    private static final String NULL_MESSAGE = "Report or FilePath can`t be null";
    private static final String EMPTY_MESSAGE = "Your report is empty";
    private static final String WRITE_EXCEPTION = "Can not write report";

    @Override
    public boolean writeCvsFile(String report, String filePath) {
        if (report == null || filePath == null) {
            throw new RuntimeException(NULL_MESSAGE);
        }
        if (report.isEmpty()) {
            throw new RuntimeException(EMPTY_MESSAGE);
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(report);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(WRITE_EXCEPTION, e);
        }
    }
}
