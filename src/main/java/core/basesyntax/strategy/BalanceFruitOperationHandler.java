package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;

public class BalanceFruitOperationHandler implements FruitOperationHandler {
    @Override
    public void operate(Fruit fruit) {
        Integer currentQuantity = Storage.fruitStorage.get(fruit.getName());
        Storage.fruitStorage.put(fruit.getName(), currentQuantity == null
                ? fruit.getQuantity() : fruit.getQuantity() + currentQuantity);
    }
}
