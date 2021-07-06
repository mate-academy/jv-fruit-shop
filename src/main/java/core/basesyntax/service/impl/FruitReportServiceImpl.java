package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FruitReportService;
import java.util.Map;

public class FruitReportServiceImpl implements FruitReportService {
    @Override
    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity").append("\n");
        for (Map.Entry<String, Integer> fruit : Storage.data.entrySet()) {
            stringBuilder.append(fruit.getKey())
                    .append(",")
                    .append(fruit.getValue())
                    .append("\n");
        }
        return stringBuilder.toString();
    }
}
