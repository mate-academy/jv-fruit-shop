package core.basesyntax.report.report;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitOperation;
import java.util.HashMap;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String SEPARATOR = ",";
    private static final String HEADER = "fruit,quantity";

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HEADER);

        Map<String, Integer> fruitQuantityMap = new HashMap<>();
        for (FruitOperation fruitOperation : Storage.SHOP_STORE) {
            fruitQuantityMap.put(fruitOperation.getFruit(),
                    fruitQuantityMap.getOrDefault(fruitOperation.getFruit(), 0)
                            + fruitOperation.getQuantity());
        }

        for (Map.Entry<String, Integer> entry : fruitQuantityMap.entrySet()) {
            int halvedQuantity = entry.getValue() / 2;
            stringBuilder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(SEPARATOR)
                    .append(halvedQuantity);
        }

        return stringBuilder.toString();
    }
}
