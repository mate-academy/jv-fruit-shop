package core.basesyntax.services.fileprocessing.impl;

import core.basesyntax.services.fileprocessing.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String INITIAL_LINE_IN_REPORT = "fruit,quantity";

    @Override
    public StringBuilder generateReport(Map<String, Integer> fruitsTypeAndAmount) {
        StringBuilder builder = new StringBuilder();
        builder.append(INITIAL_LINE_IN_REPORT);
        for (Map.Entry<String, Integer> entry : fruitsTypeAndAmount.entrySet()) {
            builder.append(System.lineSeparator()).append(entry.getKey()).append(",")
                    .append(entry.getValue());
        }
        return builder;
    }
}
