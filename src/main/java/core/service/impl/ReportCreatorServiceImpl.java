package core.service.impl;

import core.service.ReportCreatorService;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final String reportHead = "fruit,quantity";

    @Override
    public String createReport(Map<String, Integer> leftovers) {
        String report = leftovers.entrySet().stream()
                .map(k -> String.format("%s,%d", k.getKey(), k.getValue()))
                .collect(Collectors.joining(System.lineSeparator())).intern();
        return reportHead + System.lineSeparator() + report;
    }
}
