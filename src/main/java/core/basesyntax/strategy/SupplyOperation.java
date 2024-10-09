package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class SupplyOperation implements FruitOperationHandler {
    @Override
    public void executeOperation(FruitTransaction transaction, Map<String, Integer> inventory) {
        inventory.put(transaction.getFruit(),
                inventory.getOrDefault(
                        transaction.getFruit(), 0) + transaction.getQuantity());
    }
}
