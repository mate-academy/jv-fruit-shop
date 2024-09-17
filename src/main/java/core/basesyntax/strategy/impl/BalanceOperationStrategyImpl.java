package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;

public class BalanceOperationStrategyImpl implements OperationStrategy {
    @Override
    public void performOperation(FruitTransaction transaction) {
        Storage.getFruitStorage().put(transaction.getFruit(), transaction.getQuantity());
    }
}
