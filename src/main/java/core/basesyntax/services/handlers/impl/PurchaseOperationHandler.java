package core.basesyntax.services.handlers.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.exceptions.NegativeResultException;
import core.basesyntax.exceptions.NegativeValueForOperationException;
import core.basesyntax.exceptions.NoSuchFruitException;
import core.basesyntax.models.FruitTransaction;
import core.basesyntax.services.handlers.OperationHandler;
import core.basesyntax.services.handlers.OperationQuantityValidator;
import java.util.Map;

public class PurchaseOperationHandler implements OperationHandler, OperationQuantityValidator {
    private Map.Entry<String, Integer> storageEntry;

    @Override
    public void handleOperation(FruitTransaction fruitTransaction) {
        storageEntry = Storage.iterateAndFindFruits(fruitTransaction.getFruit());
        if (storageEntry != null) {
            storageEntry.setValue(validateAndGetOperationQuantity(fruitTransaction));
        } else {
            throw new NoSuchFruitException("Fruit was not found in the storage: "
                    + fruitTransaction.getFruit());
        }
    }

    @Override
    public int validateAndGetOperationQuantity(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() < 0) {
            throw new NegativeValueForOperationException("Purchase operation value for "
                    + fruitTransaction.getFruit() + " should've "
                    + "been positive but was " + fruitTransaction.getQuantity());
        }
        int fruitQuantityAfterOperation = storageEntry.getValue()
                - fruitTransaction.getQuantity();
        if (fruitQuantityAfterOperation < 0) {
            throw new NegativeResultException("Insufficient stock for purchase: Requested "
                    + fruitTransaction.getQuantity() + " but only "
                    + storageEntry.getValue() + " available for "
                    + fruitTransaction.getFruit());
        }
        return fruitQuantityAfterOperation;
    }
}
