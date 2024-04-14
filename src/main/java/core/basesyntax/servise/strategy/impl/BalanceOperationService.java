package core.basesyntax.servise.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.servise.FruitTransaction;
import core.basesyntax.servise.strategy.OperationService;

public class BalanceOperationService implements OperationService {
    @Override
    public void calculation(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        Storage.balance.merge(fruit, fruitTransaction.getQuantity(), Integer::sum);

    }
}
