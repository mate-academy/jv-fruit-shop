package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER_FRUIT = "fruit";
    private static final String HEADER_QUANTITY = "quantity";
    private static final String APPENDER = ",";

    @Override
    public String getReport(Map<Fruit, Integer> storage) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HEADER_FRUIT).append(APPENDER).append(HEADER_QUANTITY)
                .append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : storage.entrySet()) {
            stringBuilder.append(entry.getKey().getName()).append(APPENDER)
                    .append(entry.getValue()).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
