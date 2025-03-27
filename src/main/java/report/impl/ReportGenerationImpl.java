package report.impl;

import db.Storage;
import report.ReportFormatter;
import report.ReportGenerator;

public class ReportGenerationImpl implements ReportGenerator {

    @Override
    public String generateReport() {
        ReportFormatter formatter = new CsvReportFormatter();
        return formatter.format(Storage.storage);
    }
}
