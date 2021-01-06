package core.basesyntax.model;

import core.basesyntax.database.Storage;
import java.util.Map;

public class PurchaseOperation implements Operation {
    @Override
    public void doOperation(Fruit fruit, int quantity) {
        Map<Fruit, Integer> fruitsMap = Storage.getFruitsMap();
        if (!fruitsMap.containsKey(fruit)) {
            throw new RuntimeException(fruit.getName() + "s don't exist in pricelist");
        }
        if (fruitsMap.get(fruit) - quantity < 0) {
            throw new RuntimeException("Not enough " + fruit.getName() + "s");
        }
        fruitsMap.put(fruit, fruitsMap.get(fruit) - quantity);
    }
}
