package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class PurchaseOperation implements FruitOperationHandler {
    @Override
    public void executeOperation(FruitTransaction transaction, Map<String, Integer> inventory) {
        int currentBalance = inventory.getOrDefault(transaction.getFruit(), 0);
        int newBalance = currentBalance - transaction.getQuantity();

        if (newBalance < 0) {
            throw new RuntimeException(
                    "Cannot complete purchase: insufficient stock for " + transaction.getFruit());
        }

        inventory.put(transaction.getFruit(), newBalance);
    }
}
