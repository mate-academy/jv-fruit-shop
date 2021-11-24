package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String HEAD_LINE = "fruit,quantity";
    private static final String WORD_SEPARATOR = ",";

    @Override
    public String createReport(Map<Fruit, Integer> fruitStorage) {
        StringBuilder dailyReport = new StringBuilder(HEAD_LINE);
        for (Map.Entry<Fruit, Integer> fruit : fruitStorage.entrySet()) {
            dailyReport.append(System.lineSeparator())
                    .append(fruit.getKey())
                    .append(WORD_SEPARATOR)
                    .append(fruit.getValue());
        }
        return String.valueOf(dailyReport);
    }
}
