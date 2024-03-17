package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;
import java.util.Map;
import java.util.Map.Entry;

public class CsvReportGenerator implements ReportGenerator {
    private static final String REPORT_FIRST_LINE = "fruit,quantity";
    private static final String COMA = ",";

    @Override
    public String generateReport(Map<String, Integer> storageMap) {
        StringBuilder stringBuilder = new StringBuilder(REPORT_FIRST_LINE);
        for (Entry<String, Integer> entry : storageMap.entrySet()) {
            stringBuilder.append(entry.getKey()).append(COMA).append(entry.getValue());
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
