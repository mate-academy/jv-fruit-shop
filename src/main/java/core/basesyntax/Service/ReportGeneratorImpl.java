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

        for (Map.Entry<String, Integer> entry : storage.getAllFruits().entrySet()) {
            String reportLine = entry.getKey()
                    + ","
                    + entry.getValue()
                    + System.lineSeparator();
            report.add(reportLine);
        }

        StringBuilder builder = new StringBuilder();
        for (String line : report) {
            builder.append(line);
        }
        return report.toString();
    }
}
