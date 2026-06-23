package service.impl;

import db.Storage;
import service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder(HEADER);
        report.append(System.lineSeparator());
        for (var entry : Storage.fruitStorage.entrySet()) {
            report.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
