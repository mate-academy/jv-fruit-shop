package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String COMMA = ",";

    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("fruit").append(COMMA)
                .append("quantity").append(LINE_SEPARATOR);
        for (Map.Entry<Fruit, Integer> entry : Storage.fruitStorage.entrySet()) {
            stringBuilder
                   .append(entry.getKey().getName()).append(COMMA)
                   .append(entry.getValue()).append(LINE_SEPARATOR);
        }
        return stringBuilder.toString();
    }
}
