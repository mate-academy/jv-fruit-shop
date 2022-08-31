package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    public static final String TITLE = "fruit,quantity";

    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder(TITLE);
        for (Map.Entry<Fruit, Integer> fruit : Storage.storage.entrySet()) {
            builder.append(System.lineSeparator())
                    .append(fruit.getKey().getName())
                    .append(",")
                    .append(fruit.getValue());
        }
        return builder.toString();
    }
}
