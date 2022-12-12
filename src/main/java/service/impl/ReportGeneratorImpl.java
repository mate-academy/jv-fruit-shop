package service.impl;

import static java.util.stream.Collectors.joining;

import java.util.Map;
import service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String START_OF_REPORT = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String generateReport(Map<String, Integer> transactionResultMap) {
        return START_OF_REPORT + System.lineSeparator()
                + transactionResultMap.entrySet().stream()
                .filter(e -> e.getKey() != null && e.getValue() != null)
                .map(e -> e.getKey() + COMMA + e.getValue())
                .collect(joining(System.lineSeparator()));
    }
}
