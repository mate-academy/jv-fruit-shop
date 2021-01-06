package core.basesyntax.operation;

import core.basesyntax.database.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class ReturnOperation implements Operation {
    @Override
    public void doOperation(Fruit fruit, int quantity) {
        Map<Fruit, Integer> fruitsMap = Storage.getFruitsMap();
        if (!fruitsMap.containsKey(fruit)) {
            throw new RuntimeException(fruit.getName() + "s don't exist in pricelist");
        }
        fruitsMap.put(fruit, fruitsMap.get(fruit) + quantity);
    }
}
