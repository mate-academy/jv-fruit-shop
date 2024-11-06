package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        String title = "fruit,quantity\n";
        StringBuilder stringBuilder = new StringBuilder(title);
        for (Map.Entry<String, Integer> entry : FruitStorage.fruitStorage.entrySet()) {
            stringBuilder.append(entry.getKey()).append(",").append(entry.getValue()).append("\n");
        }
        return stringBuilder.toString();
    }
}
