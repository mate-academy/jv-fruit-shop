package dev.report;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String DEFAULT_DELIMETER = ",";
    private static final String HEADER = "fruit" + DEFAULT_DELIMETER + "quantity";
    private final StringBuilder stringBuilder;

    public ReportGeneratorImpl() {
        stringBuilder = new StringBuilder();
    }

    @Override
    public String getReport(Map<String, Integer> store) {
        stringBuilder.append(HEADER);
        store.forEach((key, value) -> stringBuilder.append(System.lineSeparator())
                .append(key)
                .append(DEFAULT_DELIMETER)
                .append(value));
        return stringBuilder.toString();
    }
}
