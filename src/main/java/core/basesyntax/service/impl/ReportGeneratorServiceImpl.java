package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGeneratorService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    private static final String FILE_NAME = "report.csv";
    private static final String WRITER_FAILURE_MESSAGE = "Can`t write to file %s!";

    @Override
    public void generateReport(String report) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME))) {
            bufferedWriter.write(report);
        } catch (IOException ex) {
            throw new RuntimeException(String.format(WRITER_FAILURE_MESSAGE, FILE_NAME));
        }
    }
}
