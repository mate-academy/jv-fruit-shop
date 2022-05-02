package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;

public class BalanceFruitOperation implements FruitOperation {
    @Override
    public void getCalculate(Fruit fruit) {
        Integer currentQuantity = Storage.fruitStorage.get(fruit.getName());
        Storage.fruitStorage.put(fruit.getName(), currentQuantity == null
                ? fruit.getQuantity() : fruit.getQuantity() + currentQuantity);
    }
}
