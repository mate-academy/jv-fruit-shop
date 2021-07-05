package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {

    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public String createReport() {
        stringBuilder
                .append("fruit").append(",")
                .append("quantity").append("\n");
        for (Map.Entry<Fruit, Integer> entry : Storage.fruitStorage.entrySet()) {
            stringBuilder
                   .append(entry.getKey().getName()).append(",")
                   .append(entry.getValue()).append("\n");
        }
        return stringBuilder.toString();
    }
}
