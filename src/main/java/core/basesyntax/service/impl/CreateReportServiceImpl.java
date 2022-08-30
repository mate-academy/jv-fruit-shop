package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.CreateReportService;
import java.util.Map;

public class CreateReportServiceImpl implements CreateReportService {
    private static final String TABLE_ONE = "fruit";
    private static final String TABLE_TWO = "quantity";
    private static final String FIRST_LINE_SEPARATOR = ",";

    @Override
    public String createReport(Map<Fruit, Integer> storage) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TABLE_ONE).append(FIRST_LINE_SEPARATOR).append(TABLE_TWO)
                .append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : storage.entrySet()) {
            stringBuilder.append(entry.getKey()).append(",")
                    .append(entry.getValue()).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
