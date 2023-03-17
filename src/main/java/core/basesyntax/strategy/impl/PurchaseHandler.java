package core.basesyntax.strategy.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        int newAmount = transaction.getQuantity()
                - FruitStorage.calculationStorage.get(transaction.getFruit());
        FruitStorage.calculationStorage.put(transaction.getFruit(), newAmount);
    }
}
