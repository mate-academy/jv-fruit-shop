package core.basesyntax.services.handlers.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.models.FruitTransaction;
import core.basesyntax.services.handlers.OperationHandler;
import java.util.Map;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction fruitTransaction) {
        for (Map.Entry<String, Integer> fruitTypeAndAmount : Storage.getFruitsEntrySet()) {
            if (fruitTypeAndAmount.getKey().equals(fruitTransaction.getFruit())) {
                fruitTypeAndAmount.setValue(
                        fruitTypeAndAmount.getValue() + fruitTransaction.getQuantity());
                return;
            }
        }
    }
}
