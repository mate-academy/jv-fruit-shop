package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;
import java.util.TreeMap;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String DELIMITER = ",";

    @Override
    public String getReport() {
        Map<String, Integer> sortedFruitsMap = new TreeMap<>(Storage.remainsOfFruits);
        StringBuilder report = new StringBuilder(REPORT_HEADER);
        for (Map.Entry<String, Integer> entry : sortedFruitsMap.entrySet()) {
            report.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(DELIMITER)
                    .append(entry.getValue());
        }
        return report.toString();
    }
}
