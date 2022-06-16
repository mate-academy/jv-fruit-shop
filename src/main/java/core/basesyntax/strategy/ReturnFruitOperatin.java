package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;

public class ReturnFruitOperatin implements FruitOperation {
    @Override
    public boolean operate(Fruit fruit) {
        Integer currentBalance = Storage.fruitStorage.get(fruit.getName());
        Storage.fruitStorage.put(fruit.getName(), currentBalance + fruit.getQuantity());
        return true;
    }
}
