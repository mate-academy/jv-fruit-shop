package core.basesyntax.service;

import core.basesyntax.db.FruitStorage;
import java.util.Map;

public class StoreServiceImpl implements StoreService {
    private static final String COLUMN_NAMES = "fruit,quantity";

    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder(COLUMN_NAMES);
        for (Map.Entry<String, Integer> fruits : FruitStorage.fruitsWithAmount.entrySet()) {
            stringBuilder.append(System.lineSeparator()).append(fruits.getKey()).append(",")
                    .append(fruits.getValue());
        }
        return stringBuilder.toString();
    }
}
