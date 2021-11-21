package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CreateReportService;
import java.util.List;

public class CreateReportServiceImpl implements CreateReportService {
    private static final String FIRST_LINE_REPORT = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String createReport(List<FruitTransaction> fruits) {
        StringBuilder dailyReport = new StringBuilder(FIRST_LINE_REPORT);
        for (FruitTransaction fruit : fruits) {
            dailyReport.append(System.lineSeparator())
                    .append(fruit.getName())
                    .append(COMMA)
                    .append(fruit.getAmount());
        }
        return String.valueOf(dailyReport);
    }
}
