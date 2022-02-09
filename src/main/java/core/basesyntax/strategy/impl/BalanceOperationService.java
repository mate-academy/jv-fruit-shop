package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationService;

public class BalanceOperationService implements OperationService {
    @Override
    public void processOperation(FruitTransaction fruitTransaction) {
        Storage.fruitBalance.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
