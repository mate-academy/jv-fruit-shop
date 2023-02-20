package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public String generateReport() {
        StringBuilder stringBuilder = new StringBuilder("fruit,quantity")
                .append(System.lineSeparator());

        for (Map.Entry<Fruit, Integer> entry: Storage.getStorage().entrySet()) {
            stringBuilder.append(entry.getKey().getName()).append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }

        return stringBuilder.toString();
    }
}
