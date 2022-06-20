package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;

public class PurchaseFruitOperation implements FruitOperation {
    @Override
    public void operate(Fruit fruit) {
        Integer currentBalance = Storage.fruitStorage.get(fruit.getName());
        if (currentBalance < fruit.getQuantity()) {
            throw new RuntimeException("Insufficient product to buy:" + fruit.getName());
        }
        Storage.fruitStorage.put(fruit.getName(), currentBalance - fruit.getQuantity());
    }
}
