package core.basesyntax.services.handlers.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.exceptions.NegativeValueForOperationException;
import core.basesyntax.models.FruitTransaction;
import core.basesyntax.services.handlers.OperationHandler;
import core.basesyntax.services.handlers.OperationQuantityValidator;

public class BalanceOperationHandler implements OperationHandler, OperationQuantityValidator {
    @Override
    public void handleOperation(FruitTransaction fruitTransaction) {
        Storage.updateFruit(fruitTransaction.getFruit(),
                validateAndGetOperationQuantity(fruitTransaction));
    }

    @Override
    public int validateAndGetOperationQuantity(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() < 0) {
            throw new NegativeValueForOperationException("Balance operation value for "
                    + fruitTransaction.getFruit() + " should've "
                    + "been positive but was " + fruitTransaction.getQuantity());
        }
        return fruitTransaction.getQuantity();
    }
}
