package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    @Override
    public List<String> createReport(Map<String, Integer> storageMap) {
        List<String> report = new ArrayList<>();
        report.add("fruit, quantity");
        report.add(storageMap.entrySet().stream()
                .map(e -> e.getKey() + "," + e.getValue())
                .collect(Collectors.joining(System.lineSeparator())));
        return report;
    }
}
