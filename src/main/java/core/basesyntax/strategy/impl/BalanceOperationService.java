package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.servise.FruitTransaction;
import core.basesyntax.strategy.OperationService;

public class BalanceOperationService implements OperationService {
    @Override
    public void calculation(FruitTransaction fruitTransaction) {
        Storage.balance.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
