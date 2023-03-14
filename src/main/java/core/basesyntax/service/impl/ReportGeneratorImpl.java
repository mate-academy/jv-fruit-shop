package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    public static final String HEADER = "fruit quantity";
    public static final String SPLITTER = ",";

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder(HEADER);
        for (Map.Entry<String, Integer> entry: Storage.STORAGE.entrySet()) {
            report.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(SPLITTER)
                    .append(entry.getValue());
        }
        return report.toString();
    }
}
