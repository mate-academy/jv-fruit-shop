package report.impl;

import db.Storage;
import report.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {

    @Override
    public String generateReport() {
        ReportFormatter formatter = new ReportFormatter();
        return formatter.format(Storage.storage);
    }
}
