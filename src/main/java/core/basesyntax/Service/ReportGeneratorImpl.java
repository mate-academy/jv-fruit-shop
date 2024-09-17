package core.basesyntax.service;

import core.basesyntax.ReportGenerator;
import core.basesyntax.Storage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEADER = "fruit,quantity";

    @Override
    public String getReport(Storage storage) {
        List<String> report = new ArrayList<>();
        report.add(REPORT_HEADER + System.lineSeparator());
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : storage.getAllFruits().entrySet()) {
            String reportLine = builder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator())
                    .toString();
            report.add(reportLine);
        }

        StringBuilder reportBuilder = new StringBuilder();
        for (String line : report) {
            reportBuilder.append(line);
        }
        return report.toString();
    }
}
