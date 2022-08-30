package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.CreateReportService;
import java.util.Map;

public class CreateReportServiceImpl implements CreateReportService {
    private static final String HEADER_FRUIT = "fruit";
    private static final String HEADER_QUANTITY = "quantity";
    private static final String COMA = ",";

    @Override
    public String createReport(Map<Fruit, Integer> storage) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HEADER_FRUIT).append(COMA).append(HEADER_QUANTITY)
                .append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : storage.entrySet()) {
            stringBuilder.append(entry.getKey()).append(COMA)
                    .append(entry.getValue()).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
