package core.basesyntax.service.impl;

import core.basesyntax.bd.FruitStorage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.CreateReportService;
import java.util.Map;

public class CreateReportServiceImpl implements CreateReportService {
    private static final String HEAD_LINE = "fruit,quantity";
    private static final String WORD_SEPARATOR = ",";

    @Override
    public String createReport() {
        StringBuilder dailyReport = new StringBuilder(HEAD_LINE);
        Map<Fruit, Integer> fruits = FruitStorage.fruitStorage;
        for (Map.Entry<Fruit, Integer> fruit : fruits.entrySet()) {
            dailyReport.append(System.lineSeparator())
                    .append(fruit.getKey())
                    .append(WORD_SEPARATOR)
                    .append(fruit.getValue());
        }
        return String.valueOf(dailyReport);
    }
}
