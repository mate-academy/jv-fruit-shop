package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit,quantity";
    private static final String REGEX = "%s,%s";
    @Override
    public List<String> createReport(Map<String, Integer> storage) {
        List<String> report = new ArrayList<>();
        report.add(HEADER);
        List<String> collected = storage.entrySet()
                .stream()
                .map(entry -> REGEX.formatted(entry.getKey(), entry.getValue()))
                .toList();

        report.addAll(collected);
        return report;
    }
}
