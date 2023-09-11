package core.basesyntax.service.impl;

import core.basesyntax.model.FruitInStorage;
import core.basesyntax.service.ReportService;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private static final String FIRST_LINE = "fruit,quantity";
    private static final String FIELD_SEPARATOR = ",";

    @Override
    public String generateReport(List<FruitInStorage> fruits) {
        StringBuilder report = new StringBuilder(FIRST_LINE);
        for (FruitInStorage fruit : fruits) {
            report.append(System.lineSeparator()).append(fruit.getName())
                    .append(FIELD_SEPARATOR).append(fruit.getAmount());
        }
        return report.toString();
    }
}
