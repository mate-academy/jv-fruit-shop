package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder("fruit,quantity");
        for (Map.Entry<Fruit, Integer> entry : Storage.fruits.entrySet()) {
            stringBuilder.append(System.lineSeparator())
                    .append(entry.getKey().getName())
                    .append(",")
                    .append(entry.getValue().toString());
        }
        return stringBuilder.toString();
    }
}
