package core.basesyntax.strategy.impl;

import core.basesyntax.db.CalculationStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnHandler implements OperationHandler {
    @Override
    public void calculateAndAddToStorage(FruitTransaction transaction) {
        int newAmount = CalculationStorage.CALCULATION_STORAGE.get(transaction.getFruit()) + transaction.getQuantity();
        CalculationStorage.CALCULATION_STORAGE.put(transaction.getFruit(), newAmount);
    }
}
