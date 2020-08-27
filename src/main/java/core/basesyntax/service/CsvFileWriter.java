package core.basesyntax.service;

import com.opencsv.CSVWriter;
import java.io.IOException;

public class CsvFileWriter {
    private ReportCreator reportCreator;

    CsvFileWriter() {
        this.reportCreator = new ReportCreator();
    }

    public boolean createReport(String csvOutputFile) {
        try (CSVWriter writer = new CSVWriter(new java.io.FileWriter(csvOutputFile))) {
            writer.writeAll(reportCreator.createReport());
            return true;
        } catch (IOException e) {
            throw new RuntimeException("No such file for output");
        }
    }
}
