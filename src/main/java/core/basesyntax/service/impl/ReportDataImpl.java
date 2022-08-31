package core.basesyntax.service.impl;

import core.basesyntax.service.ReportData;
import java.util.Map;
import java.util.Set;

public class ReportDataImpl implements ReportData {
    private static final String TITLE = "fruit,quantity";

    @Override
    public String createDataReport(Set<Map.Entry<String, Integer>> entries) {
        StringBuilder builder = new StringBuilder(TITLE).append("\n");
        entries.stream()
                .forEach(e -> builder.append(e.getKey()).append(",")
                        .append(e.getValue()).append(System.lineSeparator()));
        return builder.toString();
    }
}
