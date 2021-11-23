package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.CreateReportService;
import java.util.Map;

public class CreateReportServiceImpl implements CreateReportService {
    private static final String FIRST_LINE_REPORT = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String createReport(Map<Fruit, Integer> fruits) {
        StringBuilder dailyReport = new StringBuilder(FIRST_LINE_REPORT);
        for (Map.Entry<Fruit, Integer> fruit : fruits.entrySet()) {
            dailyReport.append(System.lineSeparator())
                    .append(fruit.getKey())
                    .append(COMMA)
                    .append(fruit.getValue());
        }
        return String.valueOf(dailyReport);
    }
}
