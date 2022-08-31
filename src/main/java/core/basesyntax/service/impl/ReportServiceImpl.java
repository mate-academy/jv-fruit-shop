package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String SEPARATOR = ",";

    @Override
    public String getReport() {
        StringBuilder result = new StringBuilder();
        result.append("fruit,quantity");
        for (Map.Entry<Fruit, Integer> entry : Storage.storage.entrySet()) {
            result.append(System.lineSeparator())
                    .append(entry.getKey().getName())
                    .append(SEPARATOR)
                    .append(entry.getValue());
        }
        return result.toString();
    }
}
