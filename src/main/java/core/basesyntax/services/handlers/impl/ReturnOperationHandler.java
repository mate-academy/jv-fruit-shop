package core.basesyntax.services.handlers.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.services.handlers.OperationHandler;
import java.util.Map;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void getOperation(String fruit, int returnedQuantity) {
        for (Map.Entry<String, Integer> fruitTypeAndAmount : Storage.getFruitsTypeAndAmount()
                .entrySet()) {
            if (fruitTypeAndAmount.getKey().equals(fruit)) {
                fruitTypeAndAmount.setValue(fruitTypeAndAmount.getValue() + returnedQuantity);
                break;
            }
        }
    }
}
