package core.basesyntax.service.impl;

import core.basesyntax.service.ReportWriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReportWriterServiceImpl implements ReportWriterService {
    private static final String WRITER_FAILURE_MESSAGE = "Can`t write to file %s!";

    @Override
    public void writeReport(String reportData, String reportFileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(reportFileName))) {
            bufferedWriter.write(reportData + System.lineSeparator());
        } catch (IOException ex) {
            throw new RuntimeException(String.format(WRITER_FAILURE_MESSAGE, reportFileName), ex);
        }
    }
}
