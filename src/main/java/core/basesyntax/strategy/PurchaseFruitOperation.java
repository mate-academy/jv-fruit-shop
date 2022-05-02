package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;

public class PurchaseFruitOperation implements FruitOperation {
    @Override
    public void getCalculate(Fruit fruit) {
        Integer currentQuantity = Storage.fruitStorage.get(fruit.getName());
        if (currentQuantity - fruit.getQuantity() < 0) {
            throw new RuntimeException("Can't Purchase Fruit Operation");
        }
        Storage.fruitStorage.put(fruit.getName(), currentQuantity - fruit.getQuantity());
    }
}
