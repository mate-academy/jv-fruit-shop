package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.ArrayList;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    @Override
    public List<String> generateReport(List<String> lines) {
        List<String> report = new ArrayList<>();
        String firstLineReport = "fruit, quantity" + System.lineSeparator();
        report.add(firstLineReport);
        for (String line : lines) {
            report.add(line + System.lineSeparator());
        }
        return report;
    }
}
