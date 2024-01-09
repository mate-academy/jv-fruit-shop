package core.basesyntax.services.handlers.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.exceptions.NoSuchFruitFoundException;
import core.basesyntax.models.FruitTransaction;
import core.basesyntax.services.handlers.OperationHandler;
import java.util.Map;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction fruitTransaction) {
        Map.Entry<String, Integer> fruit =
                Storage.iterateAndFindFruits(fruitTransaction.getFruit());
        if (fruit != null) {
            fruit.setValue(fruit.getValue() + fruitTransaction.getQuantity());
        } else {
            throw new NoSuchFruitFoundException("Can't return...No such fruit found...");
        }
    }
}
