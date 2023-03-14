package core.basesyntax.service.implementation;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String COLUMN_NAME = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String report(Map<String, Integer> fruitsMap) {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(COLUMN_NAME).append(System.lineSeparator());
        for (Map.Entry<String, Integer> fruit : fruitsMap.entrySet()) {
            reportBuilder.append(fruit.getKey())
                        .append(COMMA)
                        .append(fruit.getValue())
                        .append(System.lineSeparator());
        }
        return reportBuilder.toString().trim();
    }
}
