package core.basesyntax.services.handlers.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.exceptions.NegativeValueForOperationException;
import core.basesyntax.exceptions.NoSuchFruitException;
import core.basesyntax.models.FruitTransaction;
import core.basesyntax.services.handlers.OperationHandler;
import core.basesyntax.services.handlers.ValueValidator;
import java.util.Map;

public class ReturnOperationHandler implements OperationHandler, ValueValidator {
    @Override
    public void handleOperation(FruitTransaction fruitTransaction) {
        Map.Entry<String, Integer> storageEntry =
                Storage.iterateAndFindFruits(fruitTransaction.getFruit());
        if (storageEntry != null) {
            storageEntry.setValue(storageEntry.getValue()
                    + validateAndGetOperationValue(fruitTransaction));
        } else {
            throw new NoSuchFruitException("Fruit was not found in the storage: "
                    + fruitTransaction.getFruit());
        }
    }

    @Override
    public int validateAndGetOperationValue(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() < 0) {
            throw new NegativeValueForOperationException("Return operation value for "
                    + fruitTransaction.getFruit() + " should've "
                    + "been positive but was " + fruitTransaction.getQuantity());
        }
        return fruitTransaction.getQuantity();
    }
}
