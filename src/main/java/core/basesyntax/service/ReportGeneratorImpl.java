package core.basesyntax.service;

import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private Map<String, Integer> fruitMap = Storage.FRUIT_MAP;

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity");
        for (Map.Entry<String, Integer> fruit : fruitMap.entrySet()) {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(fruit.getKey());
            stringBuilder.append(",");
            stringBuilder.append(fruit.getValue());
        }
        return stringBuilder.toString();
    }
}
