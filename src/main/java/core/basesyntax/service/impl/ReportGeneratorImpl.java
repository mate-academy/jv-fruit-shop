package core.basesyntax.service.impl;

import core.basesyntax.db.DatabaseImpl;
import core.basesyntax.models.Fruit;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private DatabaseImpl storage = new DatabaseImpl();

    @Override
    public String generateReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HEADER).append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry: storage.getStorageContent()) {
            stringBuilder.append(entry.getKey().getFruitName()).append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
