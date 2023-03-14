package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGeneratorService;
import java.util.Map;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    private static final String CSV_HEADER = "fruit,quantity";
    private static final String DELIMITER = ",";

    @Override
    public String generateReportText(Map<String, Integer> storage) {
        StringBuilder report = new StringBuilder();
        report.append(CSV_HEADER).append(System.lineSeparator());
        for (Map.Entry<String, Integer> fruit : Storage.storage.entrySet()) {
            report.append(fruit.getKey())
                    .append(DELIMITER)
                    .append(fruit.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
