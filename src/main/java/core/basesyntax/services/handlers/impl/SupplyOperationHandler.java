package core.basesyntax.services.handlers.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.models.FruitTransaction;
import core.basesyntax.services.handlers.OperationHandler;
import java.util.Map;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction fruitTransaction) {
        Map.Entry<String, Integer> fruit =
                Storage.iterateAndFindFruits(fruitTransaction.getFruit());
        if (fruit != null) {
            fruit.setValue(
                    fruit.getValue() + fruitTransaction.getQuantity());
        } else {
            new BalanceOperationHandler().handleOperation(fruitTransaction);
            //handle a situation when during a working day we are supplied
            // with a product we didn't have in the morning;
        }
    }
}
