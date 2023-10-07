package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    @Override
    public String createReport(Map<String, Integer> groupedTransactions) {
        return "fruit,quantity" + System.lineSeparator()
                + groupedTransactions.entrySet().stream()
                .map(e -> e.getKey() + "," + e.getValue() + System.lineSeparator())
                .collect(Collectors.joining()).trim();
    }
}
