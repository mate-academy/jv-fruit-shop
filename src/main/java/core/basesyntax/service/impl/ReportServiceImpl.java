package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder("fruit,quantity")
                .append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : Storage.storage.entrySet()) {
            stringBuilder.append(entry.getKey().getName())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
