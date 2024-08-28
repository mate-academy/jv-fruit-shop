package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl<K, V> implements ReportGenerator {
    private static final String FIRST_COLUMN = "fruit";
    private static final String SECOND_COLUMN = "quantity";
    private static final String DELIMITER = ",";
    private static final String NEW_LINE = System.lineSeparator();
    private final Map<K, V> map;

    public ReportGeneratorImpl(Map<K, V> map) {
        this.map = map;
    }

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append(FIRST_COLUMN + DELIMITER + SECOND_COLUMN).append(NEW_LINE);

        for (Map.Entry<K, V> entry : map.entrySet()) {
            report.append(entry.getKey())
                    .append(DELIMITER)
                    .append(entry.getValue())
                    .append(NEW_LINE);
        }
        return report.toString();
    }
}
