package core.basesyntax.strategy.operation;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction, Map<String, Integer> storage) {
        int current = storage.getOrDefault(transaction.getFruit(), 0);
        if (current < transaction.getQuantity()) {
            throw new RuntimeException(
                    "Not enough " + transaction.getFruit()
                            + " to perform purchase. Available: " + current
                            + ", requested: " + transaction.getQuantity());
        }
        storage.put(transaction.getFruit(), current - transaction.getQuantity());
    }
}
