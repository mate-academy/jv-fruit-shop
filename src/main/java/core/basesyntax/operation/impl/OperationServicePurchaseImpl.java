package core.basesyntax.operation.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationService;

public class OperationServicePurchaseImpl implements OperationService {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        Fruit fruit = fruitTransaction.getFruit();
        if (FruitStorage.storage.containsKey(fruit)) {
            int newCount = FruitStorage.storage.get(fruit) - fruitTransaction.getQuantity();
            if (newCount < 0) {
                throw new RuntimeException("Something went wrong."
                        + " There is not enough fruit in storage");
            }
            FruitStorage.storage.put(fruit, newCount);
        } else {
            throw new RuntimeException("No info about this fruit - " + fruit.getName());
        }
    }
}
