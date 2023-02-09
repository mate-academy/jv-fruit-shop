package core.basesyntax.service.impl;

import core.basesyntax.service.ReportCreate;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportCreateImpl implements ReportCreate {
    private static final String REPORT_HEADER = "fruit,quantity" + System.lineSeparator();

    @Override
    public String getReport(Map<String, Integer> leftovers) {
        return REPORT_HEADER + leftovers.entrySet().stream()
                .map(f -> new StringBuilder().append(f.getKey())
                        .append(",")
                        .append(f.getValue()))
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
