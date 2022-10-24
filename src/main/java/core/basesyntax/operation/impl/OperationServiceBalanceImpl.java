package core.basesyntax.operation.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationService;

public class OperationServiceBalanceImpl implements OperationService {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        Fruit fruit = fruitTransaction.getFruit();
        if (FruitStorage.storage.containsKey(fruit)) {
            int newCount = FruitStorage.storage.get(fruit) + fruitTransaction.getQuantity();
            FruitStorage.storage.put(fruit, newCount);
        } else {
            FruitStorage.storage.put(fruit, fruitTransaction.getQuantity());
        }
    }
}
