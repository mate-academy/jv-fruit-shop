package core.basesyntax.service.impl;

import core.basesyntax.model.ReportRecord;
import core.basesyntax.service.ReportWriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvFileReportWriterService implements ReportWriterService {
    private static final String HEADER = "fruit,quantity" + System.lineSeparator();
    private final String filename;

    public CsvFileReportWriterService(String filename) {
        this.filename = filename;
    }

    @Override
    public void write(List<ReportRecord> records) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(HEADER);

            for (ReportRecord record : records) {
                writer.write(record.fruit() + "," + record.quantity() + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing file '" + filename + "'.", e);
        }
    }
}
