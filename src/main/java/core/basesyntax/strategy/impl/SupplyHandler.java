package core.basesyntax.strategy.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        int newAmount = FruitStorage.calculationStorage.get(transaction.getFruit())
                + transaction.getQuantity();
        FruitStorage.calculationStorage.put(transaction.getFruit(), newAmount);
    }
}
