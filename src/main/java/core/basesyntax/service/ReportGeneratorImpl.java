package core.basesyntax.service;

import core.basesyntax.service.impl.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String SEPARATOR = ",";
    private static final String HEADER = "fruit,quantity";

    @Override
    public String getReport(Map<String, Integer> storage) {
        StringBuilder report = new StringBuilder(HEADER);
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            report.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue());
        }
        return report.toString();
    }
}
