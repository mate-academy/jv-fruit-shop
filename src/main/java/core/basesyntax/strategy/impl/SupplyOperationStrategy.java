package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;

public class SupplyOperationStrategy implements OperationStrategy {
    @Override
    public void calculate(FruitTransaction transaction) {
        Storage.fruits.replace(transaction.getFruit(), Storage.fruits.get(transaction.getFruit()),
                Storage.fruits.get(transaction.getFruit()) + transaction.getQuantity());
    }
}
