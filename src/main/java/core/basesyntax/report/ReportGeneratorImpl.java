package core.basesyntax.report;

import core.basesyntax.models.Fruit;
import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private Storage storage = new Storage();

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
