package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> inventory) {
        int currentQuantity = inventory.getOrDefault(transaction.getFruit(), 0);
        if (currentQuantity == 0) {
            throw new RuntimeException(
                    "Fruit not available: " + transaction.getFruit());
        }
        if (currentQuantity < transaction.getQuantity()) {
            throw new RuntimeException(
                    "Insufficient quantity for fruit: " + transaction.getFruit());
        }
        inventory.put(transaction.getFruit(), currentQuantity - transaction.getQuantity());
    }
}
