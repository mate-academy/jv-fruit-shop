package core.basesyntax.services.handlers.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.services.handlers.OperationHandler;
import java.util.Map;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void getOperation(String fruit, int purchasedQuantity) {
        for (Map.Entry<String, Integer> fruitTypeAndAmount : Storage.getFruitsTypeAndAmount()
                .entrySet()) {
            if (fruitTypeAndAmount.getKey().equals(fruit)) {
                fruitTypeAndAmount.setValue(fruitTypeAndAmount.getValue() - purchasedQuantity);
                break;
            }
        }
    }
}
