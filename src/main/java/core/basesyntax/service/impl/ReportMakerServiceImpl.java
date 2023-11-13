package core.basesyntax.service.impl;

import core.basesyntax.service.ReportMakerService;
import java.util.Map;

public class ReportMakerServiceImpl implements ReportMakerService {
    private static final String TITLE_FRUIT = "fruit";
    private static final String SEPARATOR = ",";
    private static final String TITLE_QUANTITY = "quantity";

    @Override
    public String createReportString(Map<String, Integer> fruits) {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(TITLE_FRUIT).append(SEPARATOR).append(TITLE_QUANTITY);
        for (Map.Entry<String, Integer> fruit : fruits.entrySet()) {
            reportBuilder.append(System.lineSeparator());
            reportBuilder.append(fruit.getKey()).append(SEPARATOR).append(fruit.getValue());
        }
        return reportBuilder.toString();
    }
}
