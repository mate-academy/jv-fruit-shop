package core.basesyntax.strategy;

import core.basesyntax.database.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class BalanceOperation implements Operation {
    @Override
    public void doOperation(Fruit fruit, int quantity) {
        Map<Fruit, Integer> fruitsMap = Storage.getFruitsMap();
        if (fruitsMap.containsKey(fruit)) {
            throw new RuntimeException(fruit.getName() + "is already balanced");
        }
        fruitsMap.put(fruit, quantity);
    }
}
