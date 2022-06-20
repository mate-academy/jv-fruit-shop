package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;

public class ReturnFruitOperation implements FruitOperation {
    @Override
    public void operate(Fruit fruit) {
        Integer currentBalance = Storage.fruitStorage.get(fruit.getName());
        Storage.fruitStorage.put(fruit.getName(), currentBalance + fruit.getQuantity());
    }
}
