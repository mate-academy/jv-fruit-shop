package core.basesyntax.service;

import core.basesyntax.service.impl.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    public static final String SEPARATOR = ",";
    public static final String HEADER = "fruit,quantity";
    private final StringBuilder report = new StringBuilder(HEADER);

    @Override
    public String getReport(Map<String, Integer> storage) {
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            report.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue());
        }
        return report.toString();
    }
}
