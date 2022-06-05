package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceCsvImpl implements WriterService {
    public static final String REPORT_PATH = "src/main/resources/report.csv";

    @Override
    public void write(String data) {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity")
                .append(System.lineSeparator())
                .append(data);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(REPORT_PATH))) {
            bufferedWriter.write(report.toString());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + REPORT_PATH);
        }
    }
}
