package core.basesyntax.services.handlers.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.services.handlers.OperationHandler;
import java.util.Map;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void handleOperation(String fruit, int suppliedQuantity) {
        for (Map.Entry<String, Integer> fruitTypeAndAmount : Storage.fruitsTypeAndAmount
                .entrySet()) {
            if (fruitTypeAndAmount.getKey().equals(fruit)) {
                fruitTypeAndAmount.setValue(fruitTypeAndAmount.getValue() + suppliedQuantity);
                return;
            }
        }
    }
}
