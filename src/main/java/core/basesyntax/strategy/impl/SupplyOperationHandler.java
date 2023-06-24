package core.basesyntax.strategy.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        FruitStorage.fruits.merge(transaction.getFruit(), transaction.getQuantity(), Integer::sum);
    }
}
