package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import java.util.Map;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void process(FruitTransaction tx, Map<String, Integer> storage) {
        String fruit = tx.getFruit();
        int current = storage.getOrDefault(fruit, 0);

        int result = current - tx.getQuantity();

        if (result < 0) {
            throw new RuntimeException("Not enough " + fruit);
        }

        storage.put(fruit, result);
    }
}
