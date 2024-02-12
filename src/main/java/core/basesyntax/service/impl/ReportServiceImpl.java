package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    @Override
    public String generateReport(List<String> lines) {
        StringBuilder report = new StringBuilder();
        String firstLineReport = "fruit, quantity" + System.lineSeparator();
        report.append(firstLineReport);
        for (String line : lines) {
            report.append(line).append(System.lineSeparator());
        }
        return report.toString();
    }
}
