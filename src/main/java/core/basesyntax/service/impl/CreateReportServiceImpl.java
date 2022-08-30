package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.CreateReportService;

import java.util.Map;

public class CreateReportServiceImpl implements CreateReportService {
    @Override
    public String createReport(Map<Fruit, Integer> storage) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit").append(",").append("quantity")
                .append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : storage.entrySet()) {
            stringBuilder.append(entry.getKey()).append(",")
                    .append(entry.getValue()).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
