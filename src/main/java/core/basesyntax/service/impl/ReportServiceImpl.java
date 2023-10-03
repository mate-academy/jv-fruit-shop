package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public List<String> createReport(Map<String, Integer> storage) {
        List<String> report = new ArrayList<>();
        report.add("fruit, quantity");
        List<String> collected = storage.entrySet()
                .stream()
                .map(entry -> "%s,%s".formatted(entry.getKey(), entry.getValue()))
                .toList();

        report.addAll(collected);
        return report;
    }
}
