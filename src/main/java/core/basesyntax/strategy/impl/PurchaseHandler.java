package core.basesyntax.strategy.impl;

import core.basesyntax.db.CalculationStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void calculateAndAddToStorage(FruitTransaction transaction) {
        int newAmount = transaction.getQuantity()
                - CalculationStorage.calculationStorage.get(transaction.getFruit());
        CalculationStorage.calculationStorage.put(transaction.getFruit(), newAmount);
    }
}
