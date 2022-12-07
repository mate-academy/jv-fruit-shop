package service.impl;

import static java.util.stream.Collectors.joining;

import java.util.Map;
import service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String START_OF_REPORT = "fruit,quantity";

    @Override
    public String createReport(Map<String, Integer> transactionResultMap) {
        return START_OF_REPORT + System.lineSeparator()
                + transactionResultMap.entrySet().stream()
                        .map(e -> e.getKey() + "," + e.getValue())
                        .collect(joining(System.lineSeparator()));
    }
}
