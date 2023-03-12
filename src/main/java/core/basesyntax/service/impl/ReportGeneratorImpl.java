package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
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
            report.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(SPLITTER)
                    .append(entry.getValue());
        }
        return report.toString();
    }
}
