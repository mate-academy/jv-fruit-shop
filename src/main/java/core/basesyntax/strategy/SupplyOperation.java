package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> inventory) {
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException(
                    "Invalid supply quantity for fruit: " + transaction.getFruit());
        }
        inventory.put(transaction.getFruit(),
                inventory.getOrDefault(transaction.getFruit(), 0) + transaction.getQuantity());
    }
}
