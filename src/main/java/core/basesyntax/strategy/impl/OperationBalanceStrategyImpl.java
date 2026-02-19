package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;

public class OperationBalanceStrategyImpl implements OperationStrategy {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        Storage.getStorage().put(
                fruitTransaction.getFruit(),
                fruitTransaction.getQuantity()
        );
    }

}
