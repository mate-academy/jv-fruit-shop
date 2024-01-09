package core.basesyntax.services.handlers.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.exceptions.NegativeValueForOperationException;
import core.basesyntax.models.FruitTransaction;
import core.basesyntax.services.handlers.OperationHandler;
import core.basesyntax.services.handlers.ValueValidator;

public class BalanceOperationHandler implements OperationHandler, ValueValidator {
    @Override
    public void handleOperation(FruitTransaction fruitTransaction) {
        Storage.updateFruit(fruitTransaction.getFruit(),
                validateAndGetOperationValue(fruitTransaction));
    }

    @Override
    public int validateAndGetOperationValue(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() < 0) {
            throw new NegativeValueForOperationException("Balance operation value for "
                    + fruitTransaction.getFruit() + " should've "
                    + "been positive but was " + fruitTransaction.getQuantity());
        }
        return fruitTransaction.getQuantity();
    }
}
