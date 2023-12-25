package service.impl;

import db.FruitStorage;
import java.util.Map;
import service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String COLUMN_SEPARATOR = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public String getReportFromDB() {
        StringBuilder report = new StringBuilder()
                .append("fruit,quantity");

        for (Map.Entry<String, Integer> entry : FruitStorage.storage.entrySet()) {
            report.append(LINE_SEPARATOR)
                    .append(entry.getKey()).append(COLUMN_SEPARATOR).append(entry.getValue());
        }

        return report.toString();
    }
}
