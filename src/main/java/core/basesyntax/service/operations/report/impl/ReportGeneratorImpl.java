package core.basesyntax.service.operations.report.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.operations.report.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String SPLITTER_CSV = ",";
    private static final String HEADER_CSV = "fruit,quantity";
    private static final String SPLITTER_NEW_LINE = System.lineSeparator();

    public String generateReportContent(Map<Fruit, Integer> storage) {
        StringBuilder content = new StringBuilder();
        content.append(HEADER_CSV).append(SPLITTER_NEW_LINE);
        for (Map.Entry<Fruit, Integer> entry : storage.entrySet()) {
            content.append(entry.getKey().name()).append(SPLITTER_CSV).append(entry.getValue())
                    .append(SPLITTER_NEW_LINE);
        }
        return content.toString();
    }
}
