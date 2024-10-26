package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit" + "," + "quantity";

    @Override
    public String generateReport(Map<String, Integer> inventoryData) {
        List<String> reportLines = new ArrayList<>();
        reportLines.add(HEADER);
        for (Map.Entry<String, Integer> entry: inventoryData.entrySet()) {
            reportLines.add(entry.getKey() + "," + entry.getValue());
        }
        return String.join("\n", reportLines);
    }
}
