package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String title = "fruit,quantity\n";

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder(title);
        for (Map.Entry<String, Integer> entry : FruitStorage.fruitStorage.entrySet()) {
            stringBuilder.append(entry.getKey()).append(",").append(entry.getValue()).append("\n");
        }
        return stringBuilder.toString();
    }
}
