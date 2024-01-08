package core.basesyntax.services.fileprocessing.impl;

import core.basesyntax.services.fileprocessing.ReportGenerator;
import java.util.Map;
import java.util.Set;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEADER = "fruit,quantity";

    @Override
    public StringBuilder generateReport(Set<Map.Entry<String, Integer>> fruitEntrySet) {
        StringBuilder builder = new StringBuilder();
        builder.append(REPORT_HEADER);
        for (Map.Entry<String, Integer> entry : fruitEntrySet) {
            builder.append(System.lineSeparator()).append(entry.getKey()).append(",")
                    .append(entry.getValue());
        }
        return builder;
    }
}
