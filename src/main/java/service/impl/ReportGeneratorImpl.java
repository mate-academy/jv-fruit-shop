package service.impl;

import core.basesyntax.db.Storage;
import service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    public static final String FRUIT = "fruit";
    public static final String QUANTITY = "quantity";
    public static final String SPLITTER = ",";
    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append(FRUIT)
                .append(SPLITTER)
                .append(QUANTITY);
        for (Map.Entry<String, Integer> entry: Storage.STORAGE.entrySet()) {
            report.append(entry.getKey())
                    .append(System.lineSeparator())
                    .append(SPLITTER)
                    .append(entry.getValue());
        }
        return report.toString();
    }
}
