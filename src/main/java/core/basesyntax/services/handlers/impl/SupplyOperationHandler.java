package core.basesyntax.services.handlers.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.exceptions.NegativeValueForOperationException;
import core.basesyntax.models.FruitTransaction;
import core.basesyntax.services.handlers.OperationHandler;
import core.basesyntax.services.handlers.OperationQuantityValidator;
import java.util.Map;

public class SupplyOperationHandler implements OperationHandler, OperationQuantityValidator {
    @Override
    public void handleOperation(FruitTransaction fruitTransaction) {
        Map.Entry<String, Integer> storageEntry =
                Storage.iterateAndFindFruits(fruitTransaction.getFruit());
        if (storageEntry != null) {

            storageEntry.setValue(
                    storageEntry.getValue() + validateAndGetOperationQuantity(fruitTransaction));
        } else {
            new BalanceOperationHandler().handleOperation(fruitTransaction);
            //handle a situation when during a working day we are supplied
            // with a product we didn't have in the morning;
        }
    }

    @Override
    public int validateAndGetOperationQuantity(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() < 0) {
            throw new NegativeValueForOperationException("Supply operation value for "
                    + fruitTransaction.getFruit() + " should've "
                    + "been positive but was " + fruitTransaction.getQuantity());
        }
        return fruitTransaction.getQuantity();
    }
}
