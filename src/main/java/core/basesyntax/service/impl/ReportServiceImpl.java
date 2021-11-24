package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public String createReport(Map<Fruit, Integer> storage) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit, quantity\n");
        for (Map.Entry<Fruit, Integer> entry : storage.entrySet()) {
            stringBuilder.append(entry.getKey().getName())
                    .append(",")
                    .append(String.valueOf(entry.getValue()))
                    .append("\n");
        }
        return stringBuilder.toString();
    }
}
