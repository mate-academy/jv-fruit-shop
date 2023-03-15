package core.basesyntax.strategy.impl;

import core.basesyntax.db.CalculationStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceHandler implements OperationHandler {
    @Override
    public void calculateAndAddToStorage(FruitTransaction transaction) {
        CalculationStorage.calculationStorage
                .put(transaction.getFruit(), transaction.getQuantity());
    }
}
