package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.servise.FruitTransaction;
import core.basesyntax.strategy.OperationService;

public class IncomingOperationService implements OperationService {
    @Override
    public void calculation(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        Storage.balance.merge(fruit, fruitTransaction.getQuantity(), Integer::sum);
    }
}
