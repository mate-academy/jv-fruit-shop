package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction tx, Map<String, Integer> storage) {
        int current = storage.getOrDefault(tx.getFruit(), 0);
        int newBalance = current - tx.getQuantity();
        if (newBalance < 0) {
            throw new RuntimeException("Not enough stock for purchase of " + tx.getFruit()
                    + ". Current: " + current + ", requested: " + tx.getQuantity());
        }
        storage.put(tx.getFruit(), newBalance);
    }
}
