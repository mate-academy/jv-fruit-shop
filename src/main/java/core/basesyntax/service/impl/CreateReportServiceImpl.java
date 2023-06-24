package core.basesyntax.service.impl;

import core.basesyntax.service.CreateReportService;
import java.util.Map;

public class CreateReportServiceImpl implements CreateReportService {
    private static final String FRUIT_QUANTITY = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String parse(Map<String, Integer> fruitStorage) {
        StringBuilder stringBuilder = new StringBuilder(FRUIT_QUANTITY);
        for (Map.Entry<String, Integer> fruit : fruitStorage.entrySet()) {
            stringBuilder.append(System.lineSeparator())
                    .append(fruit.getValue())
                    .append(SEPARATOR)
                    .append(fruit.getKey());
        }
        return stringBuilder.toString();
    }
}
