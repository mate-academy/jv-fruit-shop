package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileWriterService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {
    @Override
    public void write(String report) {
        checkReportForNull(report);
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter("src/main/resources/output.csv"))) {
            String firstLine = "fruit,quantity" + System.lineSeparator();
            bufferedWriter.write(firstLine + report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write report in file((");
        }
    }

    private void checkReportForNull(String report) {
        if (report == null) {
            throw new RuntimeException("Input report is null!");
        }
    }
}
